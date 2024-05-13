package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Posicao de origem: ");
			ChessPosition source = UI.readchessPosition(sc);
			
			System.out.println();
			System.out.print("Posicao de destino: ");
			ChessPosition target = UI.readchessPosition(sc);
			
			ChessPiece capuredPiece = chessMatch.performChessMove(source, target);
		}
	}

}
