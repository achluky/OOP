import java.util.*;

class Something {

    private static ArrayList<Integer> bestRoute;

    public static void Permutation(ArrayList<Integer> r, ArrayList<Integer> citiesNotInRoute)
    {
        if(!citiesNotInRoute.isEmpty())
        {
            for(int i = 0; i<citiesNotInRoute.size(); i++)
            {
                Integer justRemoved = (Integer) citiesNotInRoute.remove(0);
                ArrayList<Integer> newRoute = (ArrayList<Integer>) r.clone();
                newRoute.add(justRemoved);

                Permutation(newRoute, citiesNotInRoute);
                citiesNotInRoute.add(justRemoved);
            }
        }
        else //if(citiesNotInRoute.isEmpty())
        {
            if(isBestRoute(r))
                bestRoute = r;
        }

    }

    private static boolean isBestRoute(ArrayList<Integer> r) {
        System.out.println(r.toString());
        return false;
    }

    public static void main(String[] args) {
        long tStart = System.currentTimeMillis();
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < 5; ++i)
            lst.add(i);
        ArrayList<Integer> route = new ArrayList<Integer>();
        Permutation(route, lst);
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println("Waktu yang dihabiskan :"+elapsedSeconds);
    }
}