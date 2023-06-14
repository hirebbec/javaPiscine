package controller;

import models.Tranasction;

import java.util.UUID;

public class TransactionLinkedList implements TransactionList {

    Node head;
    int size;

    public TransactionLinkedList() {
        this.head = null;
        this.size = 0;
    }

    class Node {
        public Node(Tranasction tranasction, Node next, Node prev) {
            this.tranasction = tranasction;
            this.next = next;
            this.prev = prev;
        }

        Tranasction tranasction;
        Node next;
        Node prev;
    }

    @Override
    public void addTransaction(Tranasction tranasction) {
        head = new Node(tranasction, head, null);
        if (size > 0) {
            head.next.prev = head;
        }
        size++;
    }

    @Override
    public void removeTransaction(UUID uuid) {
        if (head.tranasction.getIdentifier() == uuid) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                if (tmp.next.tranasction.getIdentifier() == uuid) {
                    tmp.next = tmp.next.next;
                    if (tmp.next != null) {
                        tmp.next.prev = tmp;
                    }
                    size--;
                    break;
                }
                tmp = tmp.next;
            }
        }
    }

    @Override
    public Tranasction[] getArray() {
        Tranasction[] tranasctions = new Tranasction[size];
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            tranasctions[i] = tmp.tranasction;
            tmp = tmp.next;
            i++;
        }
        return tranasctions;
    }

    public int countTransaction(UUID transactionUUID) {
        int count = 0;
        Node tmp = head;
        while (tmp != null) {
            if (tmp.tranasction.getIdentifier() == transactionUUID) {
                count++;
            }
            tmp = tmp.next;
        }
        return count;
    }
}
