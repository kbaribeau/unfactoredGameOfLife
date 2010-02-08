package com.kbaribeau.conway;

public class Game {
    boolean[][] grid;

    public Game(String start) {
        int sizeX = start.indexOf("\n");
        int sizeY = start.split("\n").length;
        grid = new boolean[sizeY][sizeX];

        int x = 0, y = 0;
        for (char c : start.toCharArray()) {
            switch (c) {
                case '\n':
                    y++;
                    x = 0;
                    continue;
                case '.':
                    grid[y][x] = false;
                    break;
                case 'X':
                    grid[y][x] = true;
                    break;
            }
            x++;
        }
    }


    public void tick() {
        Game newGame = new Game(toString());
        for (int y = 0; y < newGame.grid.length; y++) {
            for (int x = 0; x < newGame.grid[0].length; x++) {
				int neighborCount = 0;

				if (hasLife(y -1, x -1)) neighborCount++;
				if (hasLife(y, x -1)) neighborCount++;
				if (hasLife(y +1, x -1)) neighborCount++;
				if (hasLife(y -1, x)) neighborCount++;
				if (hasLife(y +1, x)) neighborCount++;
				if (hasLife(y -1, x +1)) neighborCount++;
				if (hasLife(y, x +1)) neighborCount++;
				if (hasLife(y +1, x +1)) neighborCount++;


                if (neighborCount == 1 || neighborCount == 0) {
                    newGame.grid[y][x] = false;
                }
                if (neighborCount > 3) {
                    newGame.grid[y][x] = false;
                }
				if (neighborCount == 3) {
					newGame.grid[y][x] = true;
				}
            }
        }

        this.grid = newGame.grid;
    }

	private boolean hasLife(int y, int x) {
        return !(y < 0 || y >= grid.length) && !(x < 0 || x >= grid[0].length) && grid[y][x];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
		for (boolean[] column : grid) {
			for (int x = 0; x < grid[0].length; x++) {
				result.append(column[x] ? "X" : ".");
			}
			result.append("\n");
		}

        return result.deleteCharAt(result.lastIndexOf("\n")).toString();
    }
}
