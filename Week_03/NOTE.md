## 散列表
散列表用的是数组支持按照下标随机访问数据的特性，所以散列表其实就是数组的一种扩展，由数组演化而来。可以说，如果没有数组，就没有散列表。

- 参赛选手的编号我们叫作**键（key）** 或者 **关键字**
- 把参赛编号转化为数组下标的映射方法就叫作**散列函数**（或“**Hash 函数**”“**哈希函数**”）
- 散列函数计算得到的值就叫作**散列值**（或“**Hash 值**”“**哈希值**”）

### 散列函数构造
该如何构造散列函数呢？我总结了三点散列函数设计的基本要求：
1. 散列函数计算得到的散列值（Hash值）是一个非负整数；
2. 如果 key1 = key2，那 hash(key1) == hash(key2)；
3. 如果 key1 ≠ key2，那 hash(key1) ≠ hash(key2)。

### 散列冲突
因为数组的存储空间有限，也会加大散列冲突的概率。
著名的MD5、SHA、CRC等哈希算法，也无法完全避免这种散列冲突  
解决冲突的方法
- 开放寻址法（open addressing）
- 链表法（chaining）
1. 开放寻址法
- 线性探测（Linear Probing）
- 二次探测（Quadratic probing）
- 双重散列（Double hashing）

（1） 线性探测：当我们往散列表中插入数据时，如果某个数据经过散列函数散列之后，存储位置已经被占用了，我们就从当前位置开始，依次往后查找，看是否有空闲位置，直到找到为止。

（2）二次探测：线性探测每次探测的步长是 1，那它探测的下标序列就是 hash(key)+0，hash(key)+1，hash(key)+2……

二次探测探测的步长就变成了原来的“二次方”，也就是说，它探测的下标序列就是 hash(key)+0，hash(key)+12，hash(key)+22……

（3）双重散列: 意思就是不仅要使用一个散列函数。我们使用一组散列函数 hash1(key)，hash2(key)，hash3(key)……我们先用第一个散列函数，如果计算得到的存储位置已经被占用，再用第二个散列函数，依次类推，直到找到空闲的存储位置。

**装载因子**
当散列表中空闲位置不多的时候，散列冲突的概率就会大大提高。为了尽可能保证散列表的操作效率，一般情况下，我们会尽可能保证散列表中有一定比例的空闲槽位。我们用**装载因子**（load factor）来表示空位的多少。


```
装载因子的计算公式是：
散列表的装载因子=填入表中的元素个数/散列表的长度
```

装载因子越大，说明空闲位置越少，冲突越多，散列表的性能会下降。

2. 链表法  
在散列表中，每个“桶（bucket）”或者“槽（slot）”会对应一条链表，所有散列值相同的元素我们都放到相同槽位对应的链表中。

## 哈希表
### 哈希
哈希表(Hash table) ，也叫散列表，是根据关键码值（Key value）而直接进行访问的数据结构。
它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
这个映射函数叫作散列函数（Hash Function）,存放记录的数组叫作哈希表（或散列表）




















