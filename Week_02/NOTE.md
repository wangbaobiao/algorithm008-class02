
#### 树（Tree）
 - A 节点就是 B 节点的父节点，B 节点是 A 节点的子节点。B、C、D 这三个节点的父节点是同一个节点，所以它们之间互称为兄弟节点。我们把没有父节点的节点叫作根节点，也就是图中的节点 E。我们把没有子节点的节点叫作叶子节点或者叶节点，比如图中的 G、H、I、J、K、L 都是叶子节点。
 ##### 高度（Height）、深度（Depth）、层（Level）
 - 节点n的高度：n节点到叶子节点所有路径上包含节点个数的最大值。叶子节点的高度为1，往上节点的高度依次递增。
- 节点n的深度：从根节点到节点n唯一的路径的长，根节点深度为1
-层数：根节点为第一层，往下一次递增。
    - 树中节点的最大层数称之为树的深度或者高度，所以在基数为1时树的深度=树的高度=最大层数
    - 但是节点的深度和高度并没有必然的关系
- 节点的度：节点拥有的子树的个数，度为0的节点称之为叶子节点
- 树的度：是树内所有节点度的最大值
- 树的深度：树内所有节点深度的最大值，也就是所有叶子节点深度的最大值，也就是树的层数
- 树的高度：树内所有节点高度的最大值，也就是根节点的高度，也就是数的层数
 
#### 二叉树（Binary Tree）
1. 二叉树，顾名思义，每个节点最多有两个“叉”，也就是两个子节点，分别是左子节点和右子节点。  
二叉树并不要求每个节点都有两个子节点，有的节点只有左子节点，有的节点只有右子节点
- 完全二叉树:  
叶节点只能出现在最下层和次下层，并且最下面一层的结点都集中在该层最左边的若干位置的二叉树
- 满二叉树:  
除最后一层无任何子节点外，每一层上的所有结点都有两个子结点二叉树
2. 想要存储一棵二叉树，我们有两种方法
- 一种是基于指针或者引用的二叉链式存储法，
- 一种是基于数组的顺序存储法。  
(1) 链式存储法: 每个节点有三个字段，其中一个存储数据，另外两个是指向左右子节点的指针  
(2) 顺序存储法:
如果节点 X 存储在数组中下标为 i 的位置，下标为 2 * i 的位置存储的就是左子节点，下标为 2 * i + 1 的位置存储的就是右子节点。反过来，下标为 i/2 的位置存储就是它的父节点。
3. 二叉树的遍历
- 前序遍历:  
对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。
- 中序遍历:  
对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。
- 后序遍历:  
对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身。
 
(1)前序遍历的递推公式：    
preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)

(2) 中序遍历的递推公式：   
inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)

(3)后序遍历的递推公式：   
postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r


```

void preOrder(Node* root) {
  if (root == null) return;
  print root // 此处为伪代码，表示打印root节点
  preOrder(root->left);
  preOrder(root->right);
}

void inOrder(Node* root) {
  if (root == null) return;
  inOrder(root->left);
  print root // 此处为伪代码，表示打印root节点
  inOrder(root->right);
}

void postOrder(Node* root) {
  if (root == null) return;
  postOrder(root->left);
  postOrder(root->right);
  print root // 此处为伪代码，表示打印root节点
}
```
#### 二叉查找树（Binary Search Tree）
二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值

1. 二叉查找树的查找操作
```

public class BinarySearchTree {
  private Node tree;

  public Node find(int data) {
    Node p = tree;
    while (p != null) {
      if (data < p.data) p = p.left;
      else if (data > p.data) p = p.right;
      else return p;
    }
    return null;
  }

  public static class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
      this.data = data;
    }
  }
}
```

2. 二叉查找树的插入操作
```

public void insert(int data) {
  if (tree == null) {
    tree = new Node(data);
    return;
  }

  Node p = tree;
  while (p != null) {
    if (data > p.data) {
      if (p.right == null) {
        p.right = new Node(data);
        return;
      }
      p = p.right;
    } else { // data < p.data
      if (p.left == null) {
        p.left = new Node(data);
        return;
      }
      p = p.left;
    }
  }
}
```
3. 二叉查找树的删除操作

```

public void delete(int data) {
  Node p = tree; // p指向要删除的节点，初始化指向根节点
  Node pp = null; // pp记录的是p的父节点
  while (p != null && p.data != data) {
    pp = p;
    if (data > p.data) p = p.right;
    else p = p.left;
  }
  if (p == null) return; // 没有找到

  // 要删除的节点有两个子节点
  if (p.left != null && p.right != null) { // 查找右子树中最小节点
    Node minP = p.right;
    Node minPP = p; // minPP表示minP的父节点
    while (minP.left != null) {
      minPP = minP;
      minP = minP.left;
    }
    p.data = minP.data; // 将minP的数据替换到p中
    p = minP; // 下面就变成了删除minP了
    pp = minPP;
  }

  // 删除节点是叶子节点或者仅有一个子节点
  Node child; // p的子节点
  if (p.left != null) child = p.left;
  else if (p.right != null) child = p.right;
  else child = null;

  if (pp == null) tree = child; // 删除的是根节点
  else if (pp.left == p) pp.left = child;
  else pp.right = child;
}
```
 #### 哈希算法
 任意长度的二进制值串映射为固定长度的二进制值串，这个映射的规则就是**哈希算法**，而通过原始数据映射之后得到的二进制值串就是**哈希值**。
 - 从哈希值不能反向推导出原始数据（所以哈希算法也叫单向哈希算法）；
 - 对输入数据非常敏感，哪怕原始数据只修改了一个 Bit，最后得到的哈希值也大不相同；
 - 散列冲突的概率要很小，对于不同的原始数据，哈希值相同的概率非常小；
 - 哈希算法的执行效率要尽量高效，针对较长的文本，也能快速地计算出哈希值。
 
MD5哈希值  
MD5 的哈希值是 128 位的 Bit 长度
```

MD5("今天我来讲哈希算法") = bb4767201ad42c74e650c1b6c03d78fa
MD5("jiajia") = cd611a31ea969b908932d44d126d195b
```
 
 1. 应用一：安全加密  
 - MD5（MD5 Message-Digest Algorithm，MD5 消息摘要算法）
 - SHA（Secure Hash Algorithm，安全散列算法）
 - DES（Data Encryption Standard，数据加密标准）
 - AES（Advanced Encryption Standard，高级加密标准）
 
 2. 应用二：唯一标识   
 我们可以给每一个图片取一个唯一标识，或者说信息摘要。比如，我们可以从图片的二进制码串开头取 100 个字节，从中间取 100 个字节，从最后再取 100 个字节，然后将这 300 个字节放到一块，通过哈希算法（比如 MD5），得到一个哈希字符串，用它作为图片的唯一标识。通过这个唯一标识来判定图片是否在图库中，这样就可以减少很多工作量。
3. 应用三：数据校验  
- 通过哈希算法，对 100 个文件块分别取哈希值，并且保存在种子文件中。我们在前面讲过，哈希算法有一个特点，对数据很敏感。只要文件块的内容有一丁点儿的改变，最后计算出的哈希值就会完全不同。所以，当文件块下载完成之后，我们可以通过相同的哈希算法，对下载好的文件块逐一求哈希值，然后跟种子文件中保存的哈希值比对。如果不同，说明这个文件块不完整或者被篡改了，需要再重新从其他宿主机器上下载这个文件块。 
4. 应用四：散列函数
5. 应用五：负载均衡
6. 应用六：数据分片
7. 应用七：分布式存储

#### hashMap
- HashMap是基于哈希表实现的,每一个元素是一个key-value对,其内部通过单链表解决冲突问题,容量不足(超过了阀值)时,同样会自动增长.
- HashMap是非线程安全的,只适用于单线程环境,多线程环境可以采用并发包下的concurrentHashMap
- HashMap 实现了Serializable接口，因此它支持序列化，实现了Cloneable接口，能被克隆
- HashMap是基于哈希表的Map接口的非同步实现.此实现提供所有可选的映射操作,并允许使用null值和null键.此类不保证映射的顺序,特别是它不保证该顺序恒久不变


