package easy;

/*

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

-- The town judge trusts nobody.
-- Everybody (except for the town judge) trusts the town judge.
-- There is exactly one person that satisfies properties 1 and 2.

You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 */
public class Find_The_Town_Judge {

    public static void main(String[] args) {

        test01();
        test03();
    }

    public static int findJudge(int n, int[][] trust) {
        int[] trustScore = new int[n + 1];
        for (int[] trustPair : trust) {
            trustScore[trustPair[1]]++;
            trustScore[trustPair[0]]--;
        }
        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    private static void test01() {
        // given
        int n = 3;
        int[][] trusting = {{1, 2}, {3, 2}};

        // the Test
        var judge = Find_The_Town_Judge.findJudge(n, trusting);
        System.out.printf(" Judge is %s \n", judge);
        assert judge == 2;
    }

    private static void test03() {
        // given
        int n = 3;
        int[][] trusting = {{1, 2}, {3, 1}, {2, 3}};

        // the Test
        var judge = Find_The_Town_Judge.findJudge(n, trusting);
        System.out.printf(" Judge is %s \n", judge);
        assert judge == -1;
    }
}
