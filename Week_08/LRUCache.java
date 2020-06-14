class LRUCache {
    // 双向链表
    class DoLink{
        int key;
        int value;
        DoLink pre;
        DoLink next;
        DoLink(){}
        DoLink(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    // 保存双向链表的节点
    Map<Integer,DoLink> map = new HashMap();
    // 头尾节点
    DoLink head,tail;
    // 容量
    int capacity;
    // 已存大小
    int size = 0;
    // 初始化
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoLink();
        tail = new DoLink();
        head.next = tail;
        tail.pre = head;
    }

    // 获取key值
    public int get(int key) {
        // 判断key存在，不存在直接返回-1
        if(map.containsKey(key)){
            // 获取key的节点
            DoLink dolink = map.get(key);
            // 断开节点所在位置
            discon(dolink);
            // 将该节点移至末尾
            lead(dolink);
            return dolink.value;
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        DoLink dolink;
        // 判断key是否存在
        if(!map.containsKey(key)){
            // 不存在，大小加一
            size ++;
            // 新建节点
            dolink = new DoLink(key,value);
        }
        else{
            // 直接获取节点
            dolink = map.get(key);
            // 重新设置节点value
            dolink.value = value;
            discon(dolink);
        }
        lead(dolink);
        map.put(key,dolink);
        if(size > capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
            size--;
        }
    }
    public void discon(DoLink dolink){
        DoLink pre = dolink.pre;
        DoLink next = dolink.next;
        pre.next = next;
        next.pre = pre;
    }
    public void lead(DoLink dolink){
        DoLink pre = tail.pre;
        pre.next = dolink;
        dolink.pre = pre;
        dolink.next = tail;
        tail.pre = dolink;
    }

}