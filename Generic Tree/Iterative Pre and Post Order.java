static class Pair {
    Node node;
    int state;

    Pair(Node node, int state){
      this.node = node;
      this.state = state;
    }
  }

  public static void IterativePreandPostOrder(Node node) {
    Pair p = new Pair(node, -1);
    Stack<Pair> st = new Stack<>();
    st.push(p);

    String preOrder = "";
    String postOrder = "";

    while(st.size() > 0){
      Pair top = st.peek();
      if(top.state == -1){
        preOrder += top.node.data + " ";
        top.state++;
      } else if (top.state >= 0 && top.state < top.node.children.size()){
        Pair cp = new Pair(top.node.children.get(top.state), -1);
        st.push(cp);

        top.state++;
      } else {
        postOrder += top.node.data + " ";
        st.pop();
      }
    }

    System.out.println(preOrder);
    System.out.println(postOrder);
  }
