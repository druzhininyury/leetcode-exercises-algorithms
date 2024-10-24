package ru.druzhininyy.leetcode.exercises.algorithms.contest;

import java.util.*;

public class Q3a {

    public static int minOperations(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        maxValue = Math.min(maxValue, 2);

        List<Integer> primes = new ArrayList<>();
        int[] spf = new int[maxValue + 1]; // Smallest Non-composite Factor (prime or 1)
        int[] gpd = new int[maxValue + 1]; // Greatest Proper Divisor

        spf[1] = 1;
        spf[2] = 2;

        // Filling spf and gpd
        for (int idx = 3; idx < spf.length; idx++) {
            if (idx % 2 == 0) {
                spf[idx] = 2;
                gpd[idx] = idx / 2;
                continue;
            }

            if (spf[idx] == 0) {
                spf[idx] = idx;
                primes.add(idx);
            }

            for (Integer prime : primes) {
                int nextIdx = idx * prime;
                if (nextIdx > maxValue) {
                    break;
                }

                spf[nextIdx] = prime;
                gpd[nextIdx] = idx;
            }
        }

        // Counting actions
        int result = 0;

        for (int idx = nums.length - 2; idx >= 0; --idx) {
            while (nums[idx] > nums[idx + 1]) {
                int currentGPD = gpd[nums[idx]];
                if (currentGPD == 0) {
                    return -1;
                }
                nums[idx] /= currentGPD;
                result += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(minOperations(new int[] {25, 7}));
//        System.out.println(minOperations(new int[] {9, 2}));
//        System.out.println(minOperations(new int[] {9, 27, 81, 27, 3}));
          System.out.println(minOperations(new int[] {1783,2531,3313,3347,3539,3821,3853,4409,6217,10099,12163,13873,14713,15017,16411,17483,17609,18433,18701,19259,19489,21737,22651,23431,24659,27067,27739,28759,30113,30853,31973,33329,33569,34919,35089,35533,35851,37087,37967,38011,38327,38561,39217,39521,39563,39971,42187,42487,45191,45887,46447,46591,48397,50227,51169,51829,53777,53891,54679,56087,56827,59243,59999,60449,60509,60869,61001,62137,63533,64091,64223,65129,65717,66037,66863,67213,67777,70139,70957,71353,71453,77419,77471,78079,78539,79621,79823,80429,80831,81929,86453,87299,88801,89527,90089,91367,92671,92737,93287,96289,98947,98999,99259,100417,101149,101561,101603,104327,106279,109873,110753,110807,111269,113173,113371,113453,115513,115523,115601,119107,119297,119827,122561,123931,124021,124199,124247,124297,124459,125107,125269,125527,126211,127637,128971,129097,129509,131267,131437,133543,134341,135301,136133,137507,137941,138599,138637,138899,139091,141277,143593,143947,145009,145547,148303,148457,151799,152501,152843,153137,153437,153763,154387,154823,155251,156679,156979,157189,157513,158017,158351,159589,160079,160681,162269,163321,163483,164093,165551,167177,167483,168089,173273,176261,176299,176389,176629,177623,177967,178127,178681,180161,181757,181997,184003,185893,186211,187091,187111,187141,187897,189697,189887,189929,190181,191791,192053,193031,193883,194867,195193,196177,196961,197423,198641,201233,202021,205963,207511,210193,210257,212851,213173,213721,213833,214657,214783,215087,215573,217027,217363,217519,219097,219587,221471,223247,223681,224113,225931,226753,226813,227569,227719,227797,229133,230257,230339,231461,233161,234161,236143,237151,237883,238363,240151,240203,241271,241561,242873,245671,245741,247141,247433,247553,248203,248579,249499,249971,251143,251443,251513,251903,252761,253507,253871,254141,254407,255043,255097,255877,258743,259631,259733,263521,263729,264763,266899,267833,268607,269167,269597,269897,273233,273569,274277,274583,275047,275941,276007,277999,280507,280697,280699,281273,281297,282053,282563,283097,283303,284173,284831,285953,288559,289019,290119,291013,291377,292679,293467,294157,294169,297967,300749,301583,302969,303029,304393,304663,305533,306503,306589,307339,308081,308849,309503,314623,314983,315569,316801,317701,317959,319169,320329,321779,323009,323413,323443,323879,324073,324451,326779,328519,329233,331613,331613,331801,332711,332903,334897,336757,338461,340429,341863,345547,345581,346667,348443,349849,352049,353117,353459,353557,354037,354313,354463,354997,356311,356761,357767,358573,359129,359731,361577,364069,364753,365251,366341,367049,367097,367613,368411,368539,369983,372107,373621,374299,375259,375481,376231,379439,386173,386621,388937,388991,390809,391103,392087,392699,392849,394241,394819,395111,395891,396629,398339,398591,399677,402139,402403,403483,404819,406717,407179,407579,409943,412771,412949,413579,413597,414013,415171,417127,419459,420263,420397,421907,422137,424247,425237,426077,426941,427949,430819,431567,432007,432337,434363,435571,437321,439511,439687,439867,440039,440329,440569,440911,442577,443567,443603,445261,446323,446827,447541,448969,450493,451663,451967,452213,456091,458789,459521,460451,460637,461917,462827,463291,463549,463787,464437,464941,465407,468011,468653,468913,469069,469193,473219,475927,475973,477941,478207,478787,479081,481249,482117,482437,483239,483563,484607,486839,487111,488203,489061,489427,491483,491531,492893,493369,494083,494471,495037,495851,496747,497261,498469,498611,504799,507401,507779,507953,510127,511391,511417,512579,512717,512819,513427,514783,522199,523463,523763,524221,524893,525697,526681,527123,527741,529121,529547,530527,530969,531121,532267,533009,533177,535999,537307,538649,538841,539863,540779,540809,541993,542441,544139,544273,547817,548291,548503,550609,551693,551729,552263,552757,553093,555073,558539,559211,559313,559859,559973,560437,560489,560929,561907,563131,564593,564709,565049,565723,567323,567871,569507,570961,571589,575579,577153,577981,578029,578621,579529,579629,579637,580163,580513,582221,582223,588773,589717,592087,592217,592261,592517,593629,595039,595319,596083,596293,597133,598613,599023,600101,600361,600979,601067,601187,602057,604411,604433,605617,607517,608431,610163,610639,610879,611551,611657,613247,615101,616843,617039,617887,619981,620003,621083,621983,624251,624479,624997,626887,627659,628997,629003,629819,629963,630841,631717,631853,632851,633583,634141,634567,636409,637601,638159,638839,639263,641089,641419,643031,645347,645833,645839,647587,648217,649063,654223,654877,655219,655561,656063,656791,656917,657029,657743,659723,660719,662551,668623,670727,670991,673397,673811,674071,674321,674677,675601,675863,676763,677077,677543,678437,678653,679603,682259,683201,683747,684373,686437,686453,687161,690037,690689,691463,694763,695581,696659,700367,704807,707111,710903,712301,712601,714073,714227,714773,714943,716501,716869,717259,718919,719153,720151,720241,722257,724331,724723,726379,727691,728627,730021,730069,731201,733283,733289,734197,735193,737111,737119,737287,738217,747157,753373,753527,754043,754973,755791,757297,759193,759821,759881,759929,760567,762659,763043,763183,763381,766097,768541,768653,770663,771763,771781,772477,775573,776077,777317,777589,778511,779173,782941,783373,783689,784481,784841,785101,786059,790021,790871,792709,795479,796487,797473,798143,799031,799727,800399,800651,801379,803479,805271,807241,807251,809261,810517,810671,811757,812213,812503,812701,814579,815627,815977,816157,816581,816709,817211,818689,819271,819719,820411,821329,823777,824081,824081,824183,824699,824749,831217,831781,832157,832613,833873,833977,834221,835993,836063,836863,837611,838247,839221,839353,842141,842599,842993,844517,844651,848017,848269,849271,849349,850009,850211,850253,850637,851491,855203,855821,856831,856949,857081,859037,859783,861013,861433,861941,862501,862571,862571,862987,863179,863843,866051,869273,871837,874457,875851,877181,877213,877237,879661,879713,880699,881611,881983,882883,883537,884167,884371,885733,885737,887459,887921,889727,890437,893381,894011,896381,897629,899177,899401,899807,901093,901171,902087,902477,902477,902669,902827,903037,903757,905249,905461,905491,907367,907513,909239,909409,909481,910807,910817,911161,911419,914813,915301,917083,917141,917633,919063,919631,922681,923963,924337,925291,925423,925621,926411,926659,926689,928097,930323,930841,932317,933601,936619,936917,937681,937777,938089,938611,939203,940201,940279,941741,941971,944309,946109,946369,946697,946741,954509,955333,955541,956377,956999,958007,962363,962783,964559,965101,965227,967391,969301,970063,971279,972197,973439,973459,974387,974419,974879,976013,976849,977447,977849,978203,978683,980131,980393,981133,981319,983267,984391,984587,985129,985499,985679,987211,987587,988789,992111,993781,994751,994879,995173,996881,996953,997201,999491,999671}));
    }

}