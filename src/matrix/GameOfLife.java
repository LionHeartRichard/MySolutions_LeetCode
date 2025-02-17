package matrix;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/*
 * Доска состоит из сетки m x n ячеек, где каждая ячейка имеет начальное состояние: 
 * живая (представлена ​​1) или мертвая (представлена ​​0). 
 * Каждая ячейка взаимодействует со своими восемью соседями 
 * (горизонтальная, вертикальная, диагональная) с использованием следующих четырех правил:
 * 
 * Любая живая клетка с менее чем двумя живыми соседями умирает, как будто из-за недонаселения.
 * Любая живая клетка с двумя или тремя живыми соседями живет в следующем поколении.
 * Любая живая клетка с более чем тремя живыми соседями умирает, как будто из-за перенаселения.
 * 
 * Любая мертвая клетка с ровно тремя живыми соседями становится живой клеткой, как будто из-за размножения.
 * 
 * Следующее состояние доски определяется путем одновременного применения вышеуказанных правил к каждой ячейке 
 * в текущем состоянии доски сетки m x n. В этом процессе рождение и смерть происходят одновременно.
 * Учитывая текущее состояние доски, обновите доску, чтобы отразить ее следующее состояние.
 * Обратите внимание, что вам не нужно ничего возвращать.
 */

public class GameOfLife {

	public void gameOfLife(int[][] board) {

		if (board == null || board.length == 0)
			return;
		int m = board.length, n = board[0].length;

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int lives = liveNeighbors(board, m, n, i, j);

				// In the beginning, every 2nd bit is 0;
				// So we only need to care about when will the 2nd bit become 1.
				if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
					board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
				}
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
				}
			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] >>= 1; // Get the 2nd state.
			}
		}
	}

	public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
		int lives = 0;
		for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); ++x) {
			for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); ++y) {
				lives += board[x][y] & 1;
			}
		}
		lives -= board[i][j] & 1;
		return lives;
	}

	@Test
	public void case1() {
		int[][] actual = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};

		int[][] expected = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
		gameOfLife(actual);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[][] actual = {{1, 1}, {1, 0}};

		int[][] expected = {{1, 1}, {1, 1}};
		gameOfLife(actual);

		assertArrayEquals(expected, actual);
	}
}
