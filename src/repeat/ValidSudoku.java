package repeat;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * Определите, является ли доска судоку 9 x 9 допустимой. Только заполненные ячейки должны 
 * быть проверены в соответствии со следующими правилами:
 * 
 * Каждая строка должна содержать цифры 1-9 без повторений.
 * Каждый столбец должен содержать цифры 1-9 без повторений.
 * Каждый из девяти подполей 3 x 3 сетки должен содержать цифры 1-9 без повторений.
 */

public class ValidSudoku {

	public static final int LEN = 9;
	public static final char CH = '.';

	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < LEN; ++i) {
			// 9 раз алацируем кэш для валидации судоку
			boolean[] rows = new boolean[LEN];
			boolean[] columns = new boolean[LEN];
			boolean[] box = new boolean[LEN];

			for (int j = 0; j < LEN; ++j) {
				char chRow = board[i][j];
				// проверяем валидность строки
				if (chRow != CH) {
					int idx = chRow - '1';
					if (rows[idx])
						return false;
					rows[idx] = true;
				}
				char chCol = board[j][i];
				// проверяем валидность столбца
				if (chCol != CH) {
					int idx = chCol - '1';
					if (columns[idx])
						return false;
					columns[idx] = true;
				}
				// хитро-мудро считаем индексы квадрата
				int x = i / 3 * 3 + j / 3;
				int y = i % 3 * 3 + j % 3;
				// проверяем валидность квадрата 3 на 3
				char chBox = board[x][y];
				if (chBox != CH) {
					int idx = chBox - '1';
					if (box[idx])
						return false;
					box[idx] = true;
				}
			}
		}
		return true;
	}

	@Test
	public void case1() {
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		assertTrue(isValidSudoku(board));
	}
}
