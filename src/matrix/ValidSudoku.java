package matrix;

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
	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; ++i) {

			// 9 раз алацируем кэш для валидации судоку
			boolean[] rows = new boolean[9];
			boolean[] columns = new boolean[9];
			boolean[] box = new boolean[9];

			for (int j = 0; j < 9; ++j) {

				// проверяем валидность строки
				char chRow = board[i][j];
				if (chRow != '.') {
					if (rows[chRow - '1'])
						return false;
					rows[chRow - '1'] = true;
				}

				// проверяем валидность столбца
				char chCol = board[j][i];
				if (chCol != '.') {
					if (columns[chCol - '1'])
						return false;
					columns[chCol - '1'] = true;
				}

				// хитро-мудро считаем индексы квадрата
				int x = i / 3 * 3 + j / 3;
				int y = i % 3 * 3 + j % 3;
				// проверяем валидность квадрата 3 на 3
				char chBox = board[x][y];
				if (chBox != '.') {
					if (box[chBox - '1'])
						return false;
					box[chBox - '1'] = true;
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
