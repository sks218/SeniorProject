package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Contains the URLs needed to access meter data
 *
 * @author willt
 * @version Sep 29, 2017
 */
public class Sources
{
    private static final String[] al = {"Amps A", "Amps B", "Amps C", "Frequency", "Power Fac A", "Power Fac B", "Power Fac C", "Power Factor", "VA", "Volts A-N", "Volts B-N", "Volts C-N", "Watts Total"};
    private static final String[] ap = {"Daily Energy", "Daily Power"};
    /**
     * A list of urls the RawData class can access
     */
    public static final HashMap<String, String> url_list = new HashMap<String, String>();
    /**
     * A list of valid inputs that can be used in the JSONParser class
     */
    public static final ArrayList<String> list_attributes = new ArrayList<String>(Arrays.asList(al));
    /**
     * A list of valid inputs that can be used in the JSONParser class
     */
    public static final ArrayList<String> point_attributes = new ArrayList<String>(Arrays.asList(ap));
    /**
     * urls and building names are hard-coded into this contructor
     */
    public Sources()
    {
        //url_list = new HashMap<String, String>();
        url_list.put(
            "AlphaChiOmega",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogoGU2Q6M45hGA6wBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xBTFBIQUNISU9NRUdB/recorded");
        url_list.put(
            "AlphaGammaDelta",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogNjV_wJjc5RGA5QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xBTFBIQUdBTU1BREVMVEE/recorded");
        url_list.put(
            "AlphaPhi",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogagX_-wmS5hGA7wBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xBTFBIQVBISQ/recorded");
        url_list.put(
            "AlphaTauOmega",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogZG-3CwqS5hGA7wBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xBTFBIQVRBVU9NRUdB/recorded");
        url_list.put(
            "Brodhead",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogXGq15BWd5hGA7wBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xCUk9ESEVBRA/recorded");
        url_list.put(
            "Centennial1",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPog1um8yZjc5RGA5QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xDRU5URU5OSUFMMQ/recorded");
        url_list.put(
            "Centennial2",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogKgMRA2Dw5RGA6ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xDRU5URU5OSUFMMg/recorded");
        url_list.put(
            "ChiPhi",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogLFOTFZnc5RGA5QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xDSElQSEk/recorded");
        url_list.put(
            "ChiPsi",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPog07zcXwqS5hGA7wBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xDSElQU0k/recorded");
        url_list.put(
            "DeltaChi",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPognpq5UWd45RGA2QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xERUxUQUNISQ/recorded");
        url_list.put(
            "DeltaUpsilon",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogZkT7DhAo5hGA6gBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xERUxUQVVQU0lMT04/recorded");
        url_list.put(
            "Dravo",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPog21AqSQqS5hGA7wBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xEUkFWT0hPVVNF/recorded");
        url_list.put(
            "Drinker",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogZB45OQqS5hGA7wBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xEUklOS0VS/recorded");
        url_list.put(
            "GammaPhiBeta",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogLTw_ygmS5hGA7wBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xHQU1NQVBISUJFVEE/recorded");
        url_list.put(
            "KappaAlpha",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogdfVVTboo5hGA6gBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xLQVBQQUFMUEhB/recorded");
        url_list.put(
            "KappaAlphaTheta",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogpzLAnZjc5RGA5QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xLQVBQQUFMUEhBVEhFVEE/recorded");
        url_list.put(
            "KappaDelta",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPog5SJpFxAo5hGA6gBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xLQVBQQURFTFRB/recorded");
        url_list.put(
            "KappaSigma",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogALUsHxAo5hGA6gBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xLQVBQQVNJR01B/recorded");
        url_list.put(
            "MM",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogGDMUjZoI5hGA6QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xNTTY3/recorded");
        url_list.put(
            "PhiDeltaTheta",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPoglUdMtpjc5RGA5QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xQSElERUxUQVRIRVRB/recorded");
        url_list.put(
            "PhiKappaAlpha",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogagak0-Vj5hGA7QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xQSElLQVBQQUFMUEhB/recorded");
        url_list.put(
            "PhiKappaTheta",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPoghWZzsWd45RGA2QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xQSElLQVBQQVRIRVRB/recorded");
        url_list.put(
            "PhiSigmaKappa",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogCjfcCeZj5hGA7QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xQSElTSUdNQUtBUFBB/recorded");
        url_list.put(
            "PiBetaPhi",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogs2LiAghf5hGA7ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xQSUJFVEFQSEk/recorded");
        url_list.put(
            "PsiUpsilon",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogkNGitxhY5hGA7ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xQU0lVUFNJTE9O/recorded");
        url_list.put(
            "Richards",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogs8eDstZq5hGA7QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xSSUNIQVJEUw/recorded");
        url_list.put(
            "SayreParkA",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogB2nozNd15hGH4wBQVq9sDAUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xTQVlFUlBBUktB/recorded");
        url_list.put(
            "SayreParkB",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPog5wZu09d15hGH4wBQVq9sDAUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xTQVlFUlBBUktC/recorded");
        url_list.put(
            "SayreParkC",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPog17Ge2td15hGH4wBQVq9sDAUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xTQVlFUlBBUktD/recorded");
        url_list.put(
            "SigmaChi",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPog6CGh3AmS5hGA7wBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xTSUdNQUNISQ/recorded");
        url_list.put(
            "SigmaPhiEpsilon",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogb8ZF7Q8o5hGA6gBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xTSUdNQVBISUVQU0lMT04/recorded");
        url_list.put(
            "Taylor",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogq9YxdnkC5hGA6ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUQVlMT1I/recorded");
        url_list.put(
            "ThetaChi",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogdDgumGd45RGA2QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUSEVUQUNISQ/recorded");
        url_list.put(
            "ThetaXi",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogn_hcp5jc5RGA5QBQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUSEVUQVhJ/recorded");
        url_list.put(
            "TrembleyA",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPog9URcBnkC5hGA6ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUUkVNQkxFWUE/recorded");
        url_list.put(
            "TrembleyB",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPog0Dl2OXkC5hGA6ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUUkVNQkxFWUI/recorded");
        url_list.put(
            "TrembleyC",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogkKNyRXkC5hGA6ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUUkVNQkxFWUM/recorded");
        url_list.put(
            "TrembleyD",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogpF0_TXkC5hGA6ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUUkVNQkxFWUQ/recorded");
        url_list.put(
            "TrembleyE",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogBJdJVXkC5hGA6ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUUkVNQkxFWUU/recorded");
        url_list.put(
            "TrembleyF",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogzFunYXkC5hGA6ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUUkVNQkxFWUY/recorded");
        url_list.put(
            "TrembleyG",
            "https://pi-core.cc.lehigh.edu/piwebapi/streamsets/E0WsSLFDAMCEi9V3Cd3PWPogdWema3kC5hGA6ABQVq83CgUEktREFUQVxMRUhJR0hcTEVISUdIXFNIQVJLIE1FVEVSU1xUUkVNQkxFWUc/recorded");
    }
}
