package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastiling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
		
		//Movimento especial
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			//Movimento especial castling/Lado menor
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastiling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			//Movimento especial castling/Lado maior
			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastiling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}	
		}
		
		return mat;
	}
}
