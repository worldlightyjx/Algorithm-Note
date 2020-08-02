package com.yang.jianzhiofffer;

public class RandomLinkedListClone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        ListNodeClone(pHead);
        connectRandom(pHead);
        return splitNode(pHead);
    }

    public void ListNodeClone(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode!=null){
            RandomListNode cloneNode = new RandomListNode(pNode.label);
            cloneNode.random  = null;
            cloneNode.next = pNode.next;
            pNode.next = cloneNode;
            pNode = cloneNode.next;
        }
    }
    public void connectRandom(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode!=null){
            RandomListNode pclone = pNode.next;
            if(pNode.random!=null){
                pclone.random = pNode.random.next;
            }
            pNode = pclone.next;
        }
    }

    public RandomListNode splitNode(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pCloneHead = null;
        RandomListNode pCloneNode = null;

        if(pNode!=null){
            pCloneHead = pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        while (pNode!=null){
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }

        return pCloneHead;
    }

}
