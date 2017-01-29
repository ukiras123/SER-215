package temp;

import javax.swing.JFileChooser;

public class FileSystem {

	public static void main(String[] args) {
		java.io.File file = null;
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
		}

		System.out.println("Does it exist? " + file.exists());

		System.out.println("The file has " + file.length() + " bytes");

		System.out.println("Can it be read? " + file.canRead());

		System.out.println("Can it be written? " + file.canWrite());

		System.out.println("Is it a directory? " + file.isDirectory());

		System.out.println("Is it a file? " + file.isFile());

		System.out.println("Is it absolute? " + file.isAbsolute());

		System.out.println("Is it hidden? " + file.isHidden());

		System.out.println("Absolute path is " + file.getAbsolutePath());

		System.out.println("Last modified on "
				+ new java.util.Date(file.lastModified()));

	}
}