package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//Acima
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Acima/Direita
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Acima/Esquerda
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Abaixo/Direita
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Abaixo/Esquerda
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}
}
