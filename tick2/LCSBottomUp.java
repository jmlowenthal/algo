package algo.tick2;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import uk.ac.cam.rkh23.Algorithms.Tick2.*;

public class LCSBottomUp extends LCSFinder {
	public LCSBottomUp(String a, String b) {
		super(a, b);
		if (a.length() > 0 && b.length() > 0) {
			mTable = new int[mString1.length()][mString2.length()];
		}
	}

	public int getTableValueAt(int i, int j) {
		if (i < 0 || j < 0 || i >= mString1.length() || j >= mString2.length()) {
			return 0;
		}
		return mTable[i][j];
	}

	public void printTable() {
		System.out.print("\t");
		for (int j = 0; j < mString2.length(); ++j) {
			System.out.print(mString2.charAt(j) + " ");
		}
		System.out.println();

		for (int i = 0; i < mString1.length(); ++i) {
			System.out.print(mString1.charAt(i) + "\t");
			for (int j = 0; j < mString2.length(); ++j) {
				System.out.print(mTable[i][j] + " ");
			}
			System.out.println();
		}
	}

	@Override
	public int getLCSLength() {
		if (mTable == null) return 0;

		for (int i = 0; i < mString1.length(); ++i) {
			for (int j = 0; j < mString2.length(); ++j) {
				if (mString1.charAt(i) == mString2.charAt(j)) {
					mTable[i][j] = getTableValueAt(i - 1, j - 1) + 1;
				}
				else {
					mTable[i][j] = Math.max(
						getTableValueAt(i, j - 1),
						getTableValueAt(i - 1, j)
					);
				}
			}
		}

		return mTable[mString1.length() - 1][mString2.length() - 1];
	}

	@Override
	public String getLCSString() {
		if (mTable == null) return "";

		int i = mString1.length() - 1;
		int j = mString2.length() - 1;
		String str = "";
		while (i >= 0 && j >= 0) {
			int curr = getTableValueAt(i, j);
			int left = getTableValueAt(i - 1, j);
			int up = getTableValueAt(i, j - 1);

			if (left == curr) {
				--i;
			}
			else if (up == curr) {
				--j;
			}
			else {
				str = mString1.charAt(i) + str;
				--i; --j;
			}
		}

		return str;
	}

	public static void main(String[] args) {
		if (args.length < 2) return;
		LCSBottomUp lcs = new LCSBottomUp(args[0], args[1]);
		lcs.getLCSLength();
		System.out.println(lcs.getLCSString());
	}
}