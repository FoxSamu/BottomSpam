package net.shadew.dskflhafljkdrj;

public class Trainer {

    public static Generator train(int learnDepth) {
        Generator generator = new Generator(learnDepth);

        String[] lines = trainingData.split("\r\n|\r|\n");
        for (String str : lines) {
            String[] ln = str.split("#", 2); // Allow comments

            generator.learn(ln[0].trim().toLowerCase());
        }

        return generator;
    }


    // The AI trains only certain patterns and potential starting characters
    // The length of each line is not of influence except if shorter than the learning depth
    private static final String trainingData = """
        dskflhafljkdrj
        sdjkjrkeskjrhjr
        dskasjdrkdrdslk
        dsklvjsdhrjj
        wieomckkhrjekj
        dskxfioer
        kslvjkweorpkok
        lskvsjjrkjseowjkdjroekj
        sdklfjskcowjeokrjoid
        skvjoiejnjckherio
        sdvewiordksjfeowekr
        skfjldskfjsjldfjklfds
        asdfjlaskdvclkew
        sdkvjewokclkweplddr
        kdsdljkskafjoewkcmr
        avkkodoewrndpoier
        dskaljdosrkerjokd
        ajsdkxovewjkrlpodkfr
        kcvjwoekrjojdkjrweork
        asjkvhwekjrokwrjwer
        dkkewovkdmvewkokrjr
        asdkvmowekrmsodjkfdrj
        skdffadsdovkaer
        asdkvoawemrkjaerok
        dkjoewkwmoerkmv
        ewkoweogkjewgkve
        ewkfjowekrowkerj
        oksdjoskefemrper
        czhdrhfsoefkejrjr
        dkfsjerljekrjerjhburojwerjr
        ckvjweorkjkdockvjwekorjkc
        sdkfasodkfjerokjokejro
        dskflserjokdjsfeork
        adskfoajdskfowekrm
        mcvmwoekrjovker
        wodkforkjddsrhdsf
        hdksdjkfkdjejrj
        skdkvoekjrodkjrji
        hfkeicmelucmrkvhejku
        jkdncioekhgkrjcif
        jekjfikejfsdjfork
        sdkvjosekrjoekmewko
        moekrjodkfjdsr
        opqwprkjdfsdmasdkrjhjkdr
        kvoekrjjkcjsoekrdsroksjr
        ckfjoekrjdfkejmdmrmor
        vsdklrjdorkdksjkrjjr
        dksjvdsjrjsjd
        zjzklmzrmzorkmdrjdf
        asdfkjsldfkjdrmokc
        ccjsjdfjrsfskdrkdsj
        xjrskojkjorjdfkmsdfb
        bndfsjvkeoromrkdrjrjr
        qweiudksrjdfkjrjrjd
        wweorjkdnrmmr
        ekrjmdkfmsldjfskdfj
        rskdvnsdkljfsdkfjdffnr
        tdssdjfsdfmslrkj
        ysdkdlfjsdlfmksvldkrj
        usdlkfjsdrodkffmdsde
        idsfkljdfkmsdvklsdjf
        osdvmosdkfmasoakjsd
        pardvlksjdrkjsdlmvsdr
        asdkjlflskdrldskrj
        sklrjkovkmodvmksdk
        ddmvdokrojroiejr
        fvkokmokjgoejworjr
        ggkjokoekmveokwjrj
        hhkjvoekwmerokrjor
        jkovmekrmrokerjeorjk
        kjoewkmrokrieojreorij
        loekmwoirmweorijewt
        zoiewiormweiorjwefdaasdwejkhrwevhkjdvojkasvhoewjhwhjwkevhjewhkjvh
        xokmvekorjekljgevioewvwoeirjvwevjwekjrhkjdjkznbekwjqhdsfjrkjehhrj
        covemrkljwejrkewjrlwkerjsdvwehjewlhjkewjklfjkwejklkbioweiopwepgiwev
        vkbmoekjrwkerjerkjrjzkerusosefiunvsejkvejhjrhwekjhkjwevhjwejkvhwekf
        bdsfsdkhekjrhekjrhasdvjhserhekvdsjkhksjdfekjhvkejvhwewekjvhwekj
        neiwojflekrhkjwerewxvbskjvgewjkkriowejfndnbfejwruuvjdshklskhkfe
        msdkhjkerhdskjriejrvjkewhvkjewhvjkwehvhjewhjwekvkewhiorudsfs
        asdfjrkehwjkrhewkrvjwehvkewvhkdsjhkjvshskdjvhsekjhvekewjkvhwe
        asaksdvewkrhweasdvsejvhjehwhkehjwjwehkvhewhwejvhwkejhrewr
        sdvewmvdsifuasndfasasdghejefaksjdghrjkagradvnjeiwvhawhefha
        asdvhjkasdfhksjrhkvjejkfbejkrhkshdfhjdsr
        rejvklelkewlkrjkrhwkejrhjwe
        jejkwkklkehrjkhvdkjrer
        adsvjkserjerlwkjerebewhj
        jekjlerjkejflkjer
        jrjhjekwjrhjkwevehr
        jrejsvjekwjrhwekjrhwer
        jrjhjkwerhkwejrhwervhejwjkfjvhwejkrhwekrjejjedfjwjekrewkjcerkjh
        djjwjewlfkjwelkfwevewrjhwjevkewjrhwerkwjehwjkejkwejkjkwekfhwejkr
        kdfweklfjadjfkashdvweovkwoekjerkvjkwelvevjkwelrkewfklwejklrjwebjkew
        rjrdafrhskjvwejkrwjkehvewrjfaskdjvhewkjwefojdfsdgfkahsdghjf
        sdweukvwbjeikiewughvbnjewhghjiecywfgvhuiytdfgfhuytrdfcgvhgyutdfxcv
        gfhfdgghjuytfgchjiuyfghjuytgfhjuytgfhjuytgfhjuytfgchytfgc
        gfftyertyutdfgiugfhjhgfdghyutygfhgfjhgcfjhgfq
        dsvgweiworuiiweuoueibwhjeewhjjkewfjkwehjhjwehkrwerhjewr
        sdvweeioiiowebioiowefiweiorhvhjwhwehvewrhjkewjrhjhjvsvggegfwevwgfeejhuuiouewurijhjdjjjeerjvdjejr
        vejwhhrkewvewrwvjwevoewkwerokwvjewklrkewrlkwelrj
        oevkdcvlhjkds
        oehcvkjsdkjrkfjsr
        oeqweeqhrjweqwjejkchwqje
        cdskrjevsioensdvsdfsdvakshdr
        dfsdkfkjrelkrj
        dkekelwkjr
        dkfjsdkfjwejkvwelrkj
        ekkdsfklskldfjsvheoweiowieuervbcmxbeikfmssdjfevwevxkcjvwerhkjdvhwiedjsfjewodkvjwejvhkksjkldlsr
        dvhejwhvkwjebjkjnxnuienwrhdksreroworir
        dkfjoewkjqwokqkowkjejcjcmmcaowigjrj
        dzhkjveweowjfwovweitmiomkkdsjfjeworor
        dsfkweworjiwjkowvevwoeifnadsjfhawepovjewr
        cvjoiaeiuozvenveoiubhaoiuhbskjdvbawoeiuhasrhjersdviuer
        sdviuahzkjehvewrjkfwlejwelbjherwoirvweiojwoeriwejr
        zozievwkrhwkvjewhfkjdhkjehwkjvwekjnwernwejkhffwerjsokmeiowr
        zioewrkajggjklfuutryesdfgchktrsgdfxcvjlidgfcgvhjildgfcvjhcvb
        ewqbjqhweiorjhqweehrhiurewhb
        weiozsdvoweigweuirtiuewfhudioewre
        sjkawekwhvewvoiewvjovkekjkvahvajkr
        vjasdvapwdasdfpasdpfoiasdradsvkzkjhtduyasr
        uytzixbusodtyausdiiasdupogasfhejwvbfbwe
        asdviaweuvunsosihuzdvqwhejjspaeowutnzkjv
        sdfjwefpadsiojewoibvehshdjtfyuewhgfewgfui
        rerrghfgggjghjdsvqwenqwecihncwhnqcwfhnioqhno
        cqwfnqwehcfhoqwehnfhnqcwhncfewcfewcfhqwecfqwheiof
        fqweiucfqwehicfqwencfhnqwecfnewhfcuqewcfqwecnfhewcf
        wcefquwcfqweicfnqwecfnqhwecnfhqewocfhnoqcweonhcfq
        qweiufghshdfjhqwejfdsfjjweqjwepofksddpfqwejr
        jdkhewjfwejfjkwvjklwevhekwerhhwvoisimwecnewcnrh
        emmioewgncdhfkdljfoewoirowvhwehkjc
        ajshdfaskdvoewijvewpofijasdvaesmorivmkldsjrseori
        svewrwhewejirjwejjwevjewocnnweiuvnewurnrqwherhhqiuewr
        chvwewerijwifowjweovkwemroicewjfocewfjwhkjfekjwrhhqkfjq
        ewojiovewvowekfjweovkweofkmeworkjweofiwevkwekvoewkrjkf
        vkweokweorjowkdvjoewkvjweokrwbajdajksrhkjcvhewkjrhjkr
        asvaweiwuwefwefpweoifajvojasdamsdlakrjaelfkjwewkeorkjr
        skdvlewkrrjwhvkjewrhjer
        vjkwhehrewewyuuevwevjkdshjshvehjrk
        dvwehjvewjrhiuwjowerkvmemorivjskodmerh
        hjyghftguvgfhdujfdydhgtyhtrredf
        djcjsnxjsnfntjcjsnr
        nxnsjdndjdnrjdcj
        jsnxkajfnejfjsntjtifbshhdjeignr
        hdjdndjcjsndkadjejdjwjdhjednjr
        hdjcksjdhwufuebcnnsjcnshdjr
        hdjsnskejirirhfncnc
        hcncnvjjejwnaiehrndkwjw
        chjcicndnchsnzbsjfjenfjengj
        hxjcnsnxhsjfnjrjgifnxnsvcuengjjdbc
        oejfnjsnxjejdjwndjwhajwjjtrjejdj
        mxnxhzbzhudfbnejdjebfjejdne
        hdndjcjcnfbejjdjjdhfhfjfjjdjdj
        udjchdjehdnfjdtnvdjhidnryfjdbyrhcndhfgbndvbryvndhcjrbhchrnghdjbcgdjcrbhvydn
        hdjxiencjdjdjsndhdurhfuabduejfurjfgsbxhdbebdhsbdurbxhsbryfbehxhrbfhsvdjehdbshdifbdhebdusjdbdisbfirhdishebdjxnsjjdjhgdhgdjejfhdnchdjvdjdhsbfjdhjdbfkdjekdjfifudkhxjudootisohdisyptishodigshdoigsohdgishodidgyidgixgofdjfhobwochowcohwhofihqehodholhdogdhpdvkxivhdoigdbkdhidbosigdohaxogqgdoqhodoqgdpqhdlyrhpdjfhdjxbdidigfeighdfitixtjzyktxtizgxifjdjgkhrhifjpdoheobeucidbidvvdibfjddohdiebfuendhdkfhurhdjjdjdhdjshfhdkdjjfbskuxdnfbfhsjfhiddnjsjdjdndfjsnjddjnenfjudnfhfsnudsjfnfienfhsndjenfhrjdjskdhrjfudjwhfjrjfbdjdjfnjdjdjsbdjbfjdbfhfndjdjsnfhdnhrbfjsnfjsbfhfndjfdnjddnfhfnfudjfbdjsnjdhf
        vskdwekvdkvewkjvdkvhskjdhvekljrvjkehrrjvjkw
        dkvelwrjvjwhrkjr
        """;
}
