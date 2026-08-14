import java.io.*;
public class E1Q6 {
	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream("file.dat");
		DataOutputStream dos = new DataOutputStream (fos)) {
			int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
			for (int i = 0; i < num.length; i++) {
				dos.writeInt(num[i]);
			}
		} catch (IOException e) {
			System.out.print("Error : " + e.getMessage());
		}

		try (FileInputStream fos = new FileInputStream("file.dat");
		DataInputStream dos = new DataInputStream (fos)) {
			int t;
			while (true) {
				try {
					t = dos.readInt();
					System.out.print(t);
				} catch (EOFException e) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print("Fichier non trouve : " + e.getMessage());
		} catch (IOException e) {
			System.out.print("Error : " + e.getMessage());
		}
	}
}
