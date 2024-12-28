package dsproject;

class AVLTreeForTeams {
    private AVLNode root;

    // Yükseklik Hesaplama
    int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    // Maksimum Değer Hesaplama
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Sağ Dönüş
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Sol Dönüş
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Denge Faktörü Hesaplama
    int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // AVL Ağacına Yeni Eleman Ekleme
    AVLNode insert(AVLNode node, Team team) {
        if (node == null)
            return new AVLNode(team);

        // Takımları skorlarına göre sıralıyoruz
        if (team.totalPoint < node.team.totalPoint)
            node.left = insert(node.left, team);
        else if (team.totalPoint > node.team.totalPoint)
            node.right = insert(node.right, team);
        else
            return node; // Aynı skorları kabul etmiyoruz

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Dengesizlik Durumları
        if (balance > 1 && team.totalPoint < node.left.team.totalPoint)
            return rightRotate(node);

        if (balance < -1 && team.totalPoint > node.right.team.totalPoint)
            return leftRotate(node);

        if (balance > 1 && team.totalPoint > node.left.team.totalPoint) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && team.totalPoint < node.right.team.totalPoint) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Ağaca Eleman Ekleme
    public void insert(Team team) {
        root = insert(root, team);
    }

    // Ağacı Inorder Gezinme
    void inorderTraversal(AVLNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println(node.team);
            inorderTraversal(node.right);
        }
    }
}
