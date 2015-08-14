import java.util.Scanner;

public class grootsteSomMatrix {
	private final static int AANTAL_NAAAST_ELKAAR = 4;
	private final int AANTAL_OPSCHUIVINGEN = AANTAL_NAAAST_ELKAAR -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aantal = sc.nextInt();	//aantal matrices in te lezen

		for (int x = 0; x < aantal; x++) {
			int m = sc.nextInt();	//aantal rijen
			int n = sc.nextInt();	//aantal kolommen
			int matrix[][] = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int y = 0; y < n; y++) {
					matrix[i][y] = sc.nextInt();
				}
			}
			System.out.println(zoekGrootsteSom(matrix));

		}

	}
	public static int zoekGrootsteSom(int [][] matrix){

		// Als matrix' kolommen en rijen kleiner zijn dan 4
		if(matrix.length<AANTAL_NAAAST_ELKAAR && matrix[0].length<AANTAL_NAAAST_ELKAAR) return 0;
		
		// Als matrix' kolommen kleiner zijn dan 4
		// dan enkel de rijen bekijken -> verticaal zoeken
		if(matrix[0].length<AANTAL_NAAAST_ELKAAR){
			return zoekGrootsteSomKolommen(matrix);
		}

		// Als matrix' rijen kleiner zijn dan 4
		// dan enkel de kolommen bekijken -> horizontaal zoeken
		if(matrix.length<AANTAL_NAAAST_ELKAAR){
			return zoekGrootsteSomRijen(matrix);
		}

		// in het laatste geval moet je beiden (kolommen en rijen) bekijken
		// en de grootste som nemen als oplossing

		// verduidelijking code () ? true: false;
		// als conditie true is dan -> geef paramter true door anders parameter false
		int grootsteSomKolommen = zoekGrootsteSomKolommen(matrix);
		int grootsteSomRijen = zoekGrootsteSomRijen(matrix);
		return (grootsteSomKolommen<grootsteSomRijen) ? grootsteSomRijen : grootsteSomKolommen;
		
	}

	// verticaal zoeken
	zoekGrootsteSomKolommen(int[][] matrix){
		int grootsteSom =-1;
		// per kolom kijken verticaal optellen
		for(int i=0;i<matrix[0].length;i++){
			// hoeveel keer moeten we er 4 samentellen?
			// dit is aantal rijen - 3
			for(int r=0;matrix.length-AANTAL_OPSCHUIVINGEN;r++){
				// r bepaalt de index vanwaar het tellen gaat beginnen
				
				// 4 opeenvolgende getallen samentellen
				int som =0;
				for(int j=0;AANTAL_NAAAST_ELKAAR;j++){
					int index = r+j;
					som+=matrix[index][i];
				}
				// welke som grootst?
				grootsteSom = (som>grootsteSom) ? som : grootsteSom;
			}
		}

		return grootsteSom;
	}

	// horizontaal zoeken
	zoekGrootsteSomRijen(int[][] matrix){
		int grootsteSom =-1;
		// per rij kijken horizontaal optellen
		for(int i=0;i<matrix.length;i++){
			// hoeveel keer moeten we er 4 samentellen?
			// dit is aantal kolommen - 3
			for(int r=0;matrix[].length-AANTAL_OPSCHUIVINGEN;r++){
				// r bepaalt de index vanwaar het tellen gaat beginnen
				
				// 4 opeenvolgende getallen samentellen
				int som =0;
				for(int j=0;AANTAL_NAAAST_ELKAAR;j++){
					int index = r+j;
					som+=matrix[i][index];
				}
				// welke som grootst?
				grootsteSom = (som>grootsteSom) ? som : grootsteSom;
			}
		}

		return grootsteSom;
	}
}
