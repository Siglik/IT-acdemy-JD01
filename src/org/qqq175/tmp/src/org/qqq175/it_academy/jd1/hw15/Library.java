/**
 * 
 */
package org.qqq175.it_academy.jd1.hw15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author qqq175
 *
 */
public class Library {
	static int READERS_NUMBER = 6;
	static String[] booksNames = { "About Birds", "Thinking in Java", "Learn You a Haskell for Great Good", "Playboy",
	        "Data structures in Java", "The catcher in the rye", "Clojure programming", "How to program in C",
	        "The Book", "An another book", "SQL", "Cheburashka", "SQL" };
	private List<Book> books;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Library lib = new Library(booksNames);
		ExecutorService esReaders = Executors.newFixedThreadPool(2);

		for (int i = 1; i <= READERS_NUMBER; i++) {
			esReaders.execute(new Reader("Reader " + i, lib, booksNames));
		}

		esReaders.shutdown();
	}

	/**
	 * Constructs library from books name array
	 */
	public Library(String[] booksNames) {
		Random rand = new Random();
		// create books set form book names, readingRoomOnly set by random (~33%
		// is true) To ensure that all books is uniqe - create first Set then
		// List
		Set<Book> setBooks = Arrays.asList(booksNames).stream().map(s -> new Book(s, rand.nextInt(3) == 0))
		        .collect(Collectors.toCollection(HashSet::new));
		books = new ArrayList<>(setBooks);

		// print books list
		System.out.println("Avaliable books (\"book name (isReadingRoomOnly)\"):");
		books.forEach(b -> System.out.print(b.getName() + "(" + b.isReadingRoomOnly() + ")" + " | "));
		System.out.print("\n\n");
	}

	
	/**
	 * Take the book from library to reader
	 * @param bookName
	 * @param takeHome
	 * @param reader
	 * @return if success - return true, else - false
	 */
	public synchronized boolean takeBook(String bookName, boolean takeHome, Reader reader) {
		Book wantedBook = new Book(bookName);
		// is library have this books
		if (books.contains(wantedBook)) {
			wantedBook = books.get(books.indexOf(wantedBook));
			// is not taken
			if (!wantedBook.isTaken()) {
				// is reader want to take it home
				if (takeHome) {
					if (!wantedBook.isReadingRoomOnly()) {
						// take at home
						wantedBook.setTaken(true);
						wantedBook.setTakenBy(reader);
						return true;
					} else { // you can't take it home
						return false;
					}
				} else {
					// read book in reading room
					wantedBook.setTaken(true);
					wantedBook.setTakenBy(reader);
					return true;
				}
			} else { // book is already taken
				return false;
			}
		} else { // don't have this book
			return false;
		}
	}
}

class Reader implements Runnable {
	private String name;
	private Library library;
	private HashSet<String> wantedBooksNames, takenBooksNames;
	private boolean takeBooksHome;

	/**
	 * @param name
	 * @param library
	 * @param booksNames
	 */
	public Reader(String name, Library library, String[] booksNames) {
		this.name = name;
		this.library = library;
		wantedBooksNames = new HashSet<>();
		takenBooksNames = new HashSet<>();
		Random rand = new Random();

		// add to set up to 3 random books
		int booksNumber = rand.nextInt(3) + 1;
		for (int i = 0; i < booksNumber; i++) {
			wantedBooksNames.add(booksNames[rand.nextInt(booksNames.length)]);
		}

		// randomize takeBooksHome ~67 % is true
		takeBooksHome = rand.nextInt(3) != 0;
	}

	@Override
	public void run() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " is want to take books " + (takeBooksHome ? "to home" : "to reading room") + ": ");
		wantedBooksNames.forEach(b -> sb.append(b + " | "));

		for (String book : wantedBooksNames) {
			if (library.takeBook(book, takeBooksHome, this)) {
				takenBooksNames.add(book);
			}
		}
		wantedBooksNames.removeAll(takenBooksNames);

		sb.append("\n" + name + " took books: ");
		takenBooksNames.forEach(b -> sb.append(b + " | "));
		sb.append("\n" + name + " didn't take books: ");
		wantedBooksNames.forEach(b -> sb.append(b + " | "));

		System.out.println(sb.toString() + "\n");
	}
}

/**
 * class that describes book
 * 
 * @author qqq175
 *
 */
class Book {
	private String name;
	private boolean readingRoomOnly;
	private boolean taken;
	private Reader takenBy = null;

	/**
	 * @param name
	 */
	public Book(String name) {
		this.name = name;
		this.readingRoomOnly = false;
		taken = false;
	}

	/**
	 * @param name
	 * @param readingRoomOnly
	 */
	public Book(String name, boolean readingRoomOnly) {
		this.name = name;
		this.readingRoomOnly = readingRoomOnly;
		taken = false;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the readingRoomOnly
	 */
	public boolean isReadingRoomOnly() {
		return readingRoomOnly;
	}

	/**
	 * @return the taken
	 */
	public boolean isTaken() {
		return taken;
	}

	/**
	 * @param taken
	 *            the taken to set
	 */
	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	/**
	 * @return the takenBy
	 */
	public Reader getTakenBy() {
		return takenBy;
	}

	/**
	 * @param takenBy
	 *            the takenBy to set
	 */
	public void setTakenBy(Reader takenBy) {
		this.takenBy = takenBy;
	}
}