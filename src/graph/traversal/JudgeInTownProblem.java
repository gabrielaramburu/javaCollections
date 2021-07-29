package graph.traversal;

/*
 In a town, there are n people labeled from 1 to n. 
 There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.

You are given an array trust where trust[i] = [ai, bi] representing that the person 
labeled ai trusts the person labeled bi.

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

https://leetcode.com/problems/find-the-town-judge/
 */
public class JudgeInTownProblem {
	int[][] trusts;

	public int findJudge(int n, int[][] trust) {
		int result = -1;
		trusts = buildMatrix(n, trust);

		for (int j = 1; j < trusts.length; j++) {
			if (trustNoBody(j) && allTownTrustHim(j, n)) {
				result = j;
				break;
			}
		}

		return result;
	}

	private boolean trustNoBody(int j) {

		for (int i = 1; i < trusts.length; i++) {
			if (trusts[j][i] == 1)
				return false;
		}

		return true;
	}

	private boolean allTownTrustHim(int j, int n) {
		for (int i = 1; i < trusts.length; i++) {
			if (i != j) {
				if (trusts[i][j] == 0)
					return false;
			}
		}

		return true;
	}

	private int[][] buildMatrix(int n, int[][] relation) {
		int[][] trusts = new int[n + 1][n + 1];
		for (int i = 0; i < relation.length; i++) {
			int a = relation[i][0];
			int b = relation[i][1];
			trusts[a][b] = 1;
		}

		return trusts;
	}
}
