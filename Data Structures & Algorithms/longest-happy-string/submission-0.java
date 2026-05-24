class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node('a', a));
        pq.offer(new Node('b', b));
        pq.offer(new Node('c', c));

        StringBuilder sb = new StringBuilder();

        while(true) {
            Node currentNode = pq.poll();
            char currentChar = currentNode.ch;
            int currentFreq = currentNode.freq;
            if(currentFreq == 0) {
                break;
            }
            if(sb.length() >= 2) {
                char previousChar = sb.charAt(sb.length()-1);
                char characterBeforePrevious = sb.charAt(sb.length()-2);
                if(currentChar == previousChar && previousChar
                == characterBeforePrevious) {
                    Node alternateNode = pq.poll();
                    if(alternateNode.freq == 0) {
                        break;
                    }
                    sb.append(alternateNode.ch);
                    pq.offer(new Node(alternateNode.ch, alternateNode.freq - 1));
                    pq.offer(new Node(currentNode.ch, currentNode.freq));
                } else {
                    sb.append(currentChar);
                    pq.offer(new Node(currentChar, currentFreq - 1));
                }
            } else {
                sb.append(currentChar);
                pq.offer(new Node(currentChar, currentFreq - 1));
            }
        }
        return sb.toString();
    }
    private class Node implements Comparable<Node> {
        char ch;
        int freq;
        public Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Node node) {
            return node.freq - this.freq;
        }
    }
}