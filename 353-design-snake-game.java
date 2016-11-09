public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    Set<Integer> set = new HashSet<>();;
    Deque<Integer> body = new LinkedList<>();
    int score;
    int width;
    int height;
    int[][] food;
    int foodId;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set.add(0);
        body.addLast(0);
    }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
        @return The game's score after the move. Return -1 if game over.
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) return -1;
        int row = body.peekLast() / width;
        int col = body.peekLast() % width;
        switch (direction) {
            case "U":
                row--;
                break;
            case "D":
                row++;
                break;
            case "L":
                col--;
                break;
            default:
                col++;
                break;
        }
        int headId = row * width + col;
        set.remove(body.peekFirst());
        if (row < 0 || col < 0 || row == height || col == width || set.contains(headId)) return score = -1;
        set.add(headId);
        body.addLast(headId);
        if (foodId < food.length && food[foodId][0] == row && food[foodId][1] == col) {
            set.add(body.peekFirst());
            foodId++;
            return ++score;
        }
        body.removeFirst();
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
