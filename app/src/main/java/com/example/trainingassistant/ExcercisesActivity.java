package com.example.trainingassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class ExcercisesActivity extends AppCompatActivity {

    public ArrayList<SpinnerListItem> LegList = new ArrayList<>();
    public ArrayList<SpinnerListItem> ArmsList = new ArrayList<>();
    public ArrayList<SpinnerListItem> ShouldersList = new ArrayList<>();
    public ArrayList<SpinnerListItem> AbsList = new ArrayList<>();
    public ArrayList<SpinnerListItem> ChestList = new ArrayList<>();
    public ArrayList<SpinnerListItem> BackList = new ArrayList<>();

    private Spinner LegsSpinner;
    private Spinner ShouldersSpinner;
    private Spinner ArmsSpinner;
    private Spinner AbsSpinner;
    private Spinner ChestSpinner;
    private Spinner BackSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercises);

        LegsSpinner = findViewById(R.id.legs_spinner);
        ShouldersSpinner = findViewById(R.id.shoulders_spinner);
        ArmsSpinner = findViewById(R.id.arms_spinner);
        AbsSpinner = findViewById(R.id.abs_spinner);
        ChestSpinner = findViewById(R.id.chest_spinner);
        BackSpinner = findViewById(R.id.back_spinner);


        SpinnerAdapter LegsAdapter = new SpinnerAdapter(this, LegList);
        SpinnerAdapter ChestAdapter = new SpinnerAdapter(this, ChestList);
        SpinnerAdapter ShouldersAdapter = new SpinnerAdapter(this, ShouldersList);
        SpinnerAdapter AbsAdapter = new SpinnerAdapter(this, AbsList);
        SpinnerAdapter ArmsAdapter = new SpinnerAdapter(this, ArmsList);
        SpinnerAdapter BackAdapter = new SpinnerAdapter(this, BackList);

        if(LegsSpinner != null){
            LegsSpinner.setAdapter(LegsAdapter);
        }

        if(ShouldersSpinner != null){
            ShouldersSpinner.setAdapter(ShouldersAdapter);
        }

        if(ArmsSpinner != null){
            ArmsSpinner.setAdapter(ArmsAdapter);
        }

        if(ChestSpinner != null){
            ChestSpinner.setAdapter(ChestAdapter);
        }

        if(AbsSpinner != null){
            AbsSpinner.setAdapter(AbsAdapter);
        }

        if(BackSpinner != null){
            BackSpinner.setAdapter(BackAdapter);
        }

        /**
         * Inicjalizacja listy ćwiczeń na barki
         */
        ShouldersList.add(new SpinnerListItem(null,null,null));
        ShouldersList.add(new SpinnerListItem("Wyciskanie sztangi zza/sprzed głowy",
                "Przedni i boczne aktony mięśni naramiennych, mięśnie trójgłowe ramion.",
                "Stajemy w rozkroku nieco szerszym niż barki - klatka piersiowa wypchnięta ku przodowi, " +
                        "zachowana naturalna krzywizna kręgosłupa-pracują podczas ćwiczenia tylko ramiona i barki " +
                        "(staramy się unikać dodatkowych ruchów tułowia i nóg), uchwyt nieco szerszy niż rozstaw barków"));
        ShouldersList.add(new SpinnerListItem("Unoszenie sztangielek bokiem w górę.",
                "Środkowe aktony mięśni naramiennych","Ćwiczenie można wykonywać w pozycji stojącej lub siedzącej, " +
                "oburącz lub jednorącz. W pozycji wyjściowej tułów lekko pochylony, " +
                "ręce ze sztangielkami nieco ugięte w łokciach, opuszczone w dół, " +
                "dłonie wewnętrznymi stronami skierowane do środka. Ruch unoszenia rozpoczynamy przy ugiętych rękach, " +
                "łokcie w każdej fazie ruchu wyprzedzają dłonie. Sztangielki unosimy powyżej linii barków i bez zatrzymania opuszczamy powoli w dół (lub przytrzymujemy w pozycji szczytowej przez chwilę w celu dodatkowego napięcia mięśni). Ćwiczenie to można również wykonywać jednorącz sztangielką/linką na wyciągu w odchyleniu - jedną ręką chwytamy się poręczy, drugą wykonujemy ćwiczenie."));
        ShouldersList.add(new SpinnerListItem("Unoszenie sztangielek w opadzie tułowia","tylna część mięśni naramiennych",
                "Tułów ustawiamy w położeniu zbliżonym do prostopadłego do podłoża i staramy się w trakcie ruchu nie wykonywać nim tzw. bujania - utrzymujemy możliwie sztywno. Z pozycji wyjściowej ruchem kolistym unosimy sztangielki maksymalnie w górę, utrzymując przez cały czas ćwiczone mięśnie w stanie napięcia. Staramy się, aby w ruchu powrotnym sztangielki poruszały się po tym samym torze. W pozycji szczytowej można przytrzymać przez chwilę sztangielki w celu dodatkowego napięcia mięśni."));
        ShouldersList.add(new SpinnerListItem("Podciąganie sztangi wzdłuż tułowia","Wszystkie aktony mięśni naramiennych, mięsień czworoboczny grzbietu (tzw. kapturowy).",
                "Rozkrok nieco szerszy od rozstawu barków, uchwyt na szerokość ramion. Ruchem wolnym i kontrolowanym unosimy sztangę w kierunku brody, starając się, aby przemieszczała się możliwie najbliżej tułowia. Łokcie przez cały czas trzymamy powyżej gryfu sztangi. Ruch unoszenia kończymy, gdy sztanga znajdzie się na wysokości klatki piersiowej (lub staramy się podciągnąć sztangę aż do brody), opuszczamy również powoli, unikamy odchylania i bujania tułowia. Koncentrujemy się na unoszeniu łokci, a sztanga podąży za nimi."));

        /**
         * Inicjalizacja listy ćwiczeń na Klatkę
         */

        ChestList.add(new SpinnerListItem(null,null,null));
        ChestList.add(new SpinnerListItem("Wyciskanie sztangi w leżeniu na ławce poziomej",
                "Cała grupa mięśni klatki piersiowej, mięśnie trójgłowe ramion, przednie aktony mięśni naramiennych.","Opuszczamy sztangę na klatkę na wysokość ok.1 cm powyżej brodawek. Przy opuszczaniu sztangi wykonujemy głęboki wdech - wydychamy powietrze w trakcie wyciskania. Można okresowo praktykować przytrzymywanie sztangi przez chwilę na klatce przed wyciśnięciem. Łokcie prowadzimy w trakcie całego ruchu po bokach - tak, by nie „uciekały” do środka. Ruch wyciskania kończymy (dla lepszego napięcia mięśni) zanim łokcie zostaną zblokowane. "));
        ChestList.add(new SpinnerListItem("Wyciskanie sztangi w leżeniu na ławce skośnej",
                "Cała grupa mięśni klatki piersiowej z podkreśleniem jej górnej części, mięśnie trójgłowe ramion, przednie aktony mięśni naramiennych.","Uchwyt sztangi, oddychanie, prowadzenie łokci, jak w ćwiczeniu na ławce płaskiej."));
        ChestList.add(new SpinnerListItem("Rozpiętki ze sztangielkami w leżeniu na ławce poziomej",
                "Mięsień piersiowy większy.","Ćwiczenie rozpoczynamy z ramionami wyprostowanymi - prostopadłymi do podłoża (palce dłoni skierowane są do siebie), a w trakcie ruchu lekko uginamy je w łokciach. Nabieramy powietrza, gdy sztangielki są u góry (na początku ruchu), wydychamy je, gdy sztangielki wędrują do góry. W końcowej fazie ruch można zatrzymać na chwilę w celu lepszego napięcia mięśni. Staramy się nie uderzać sztangielkami o siebie, ale zatrzymywać ruch zanim się zetkną. Ważne jest wykonywanie pełnego zakresu ruchu."));
        ChestList.add(new SpinnerListItem("Pompki na poręczach",
                "Cała grupa mięśni klatki piersiowej.","W tym ćwiczeniu ważne jest, by pracę wykonywały w głównym stopniu mięśnie piersiowe, w mniejszym stopniu chodzi nam o pracę mięśni trójgłowych ramion. Elementem decydującym o większym zaangażowaniu jednych, bądź drugich mięśni jest pozycja tułowia i ułożenie łokci."));

        /**
         * Inicjalizacja listy ćwiczeń na Plecy
         */

        BackList.add(new SpinnerListItem(null,null,null));
        BackList.add(new SpinnerListItem("Podciąganie na drążku szerokim uchwytem (nachwyt)",
                " Mięśnie najszersze grzbietu.","Chwytamy drążek nachwytem na szerokość taką, by po podciągnięciu ramiona z przedramionami tworzyły kąt prosty (w przybliżeniu). Nogi ugięte w kolanach (dla lepszej stabilności można je spleść). Łokcie pracują w płaszczyźnie pleców - w jednej linii. Wdech robimy przed rozpoczęciem ruchu podciągania - wydech dopiero, gdy jesteśmy już u góry. Ruch podciągania kończymy w momencie, gdy nasza broda jest na wysokości drążka lub nieco ponad nim. Opuszczamy się wolno i pod pełną kontrolą."));
        BackList.add(new SpinnerListItem("Skłony ze sztangą trzymaną na karku",
                "Prostowniki grzbietu, dwugłowe ud, pośladkowe.","Stajemy w rozkroku nieco większym niż szerokość barków. Sztangę kładziemy na górnej części mięśni czworobocznych grzbietu. Głowa lekko wygięta do tyłu, ale bez przesady - zbytnie wyginanie głowy może być przyczyną kontuzji. Tułów wyprostowany, klatka piersiowa wypchnięta ku przodowi, łopatki ściągnięte do siebie. Nogi lekko ugięte w kolanach przez cały czas trwania ćwiczenia. Z takiej pozycji wykonujemy skłon do pozycji zbliżonej do poziomego ułożenia tułowia względem podłogi. Bez zatrzymania, ale nie szarpiąc unosimy tułów do pozycji wyjściowej. Ruch powinien być płynny i kontrolowany."));
        BackList.add(new SpinnerListItem("Martwy ciąg",
                "Prostowniki grzbietu, mięśnie najszersze grzbietu.","Stajemy przodem do sztangi, w rozkroku na szerokość barków lub nieco szerszym, nogi lekko ugięte w kolanach, gryf sztangi nad palcami stóp, sztangę chwytamy nachwytem, nieco szerzej niż barki. Klatka wypchnięta ku przodowi, tułów wyprostowany, głowa lekko zadarta do góry. Ćwiczenie polega na unoszeniu sztangi w górę poprzez prostowanie nóg i wyprost tułowia. Ruch kończymy przy pełnym wyproście tułowia - nie odchylamy go do tyłu - grozi to kontuzją. Nie wolno również dopuszczać do tzw. ”kociego grzbietu”, czyli wygięcia pleców w łuk (szczególnie w dolnym odcinku). Powrót do pozycji wyjściowej zaczynamy od lekkiego ugięcia nóg w kolanach, a następnie pochylamy tułów (oczywiście cały czas jest on wyprostowany) robiąc skłon. Nie pochylamy się jednak zbyt nisko. Ruch opuszczania ciężaru wolny i kontrolowany - sztanga nie uderza o podłogę, ale dotyka jej. "));

        /**
         * Inicjalizacja listy ćwiczeń na Ręce
         */
        ArmsList.add(new SpinnerListItem(null,null,null));
        ArmsList.add(new SpinnerListItem("Uginanie ramion ze sztangą stojąc podchwytem",
                "Obie głowy mięsnia zaangażowane w równym stopniu.","Tułów podczas ćwiczenia utrzymujemy w pozycji wyprostowanej (bez bujania nim). Zakres ruchu: od pełnego rozgięcia bicepsów (nie ramion) do pełnego ich skurczu. Pełne rozciągnięcie bicepsów, to nie to samo, co pełny wyprost ramion. Należy unikać tzw. ”przeprostów” ramion, czyli nadmiernego ich wyprostowywania (do pełnego zakresu ruchu w stawie łokciowym). Łokcie przez cały czas przylegają do tułowia - nie powinny uciekać na boki ani w przód, gdyż powoduje to zaangażowanie innych mięśni do pracy. Powietrza nabieramy w pozycji wyjściowej, wypuszczamy je dopiero po przejściu ciężaru przez najtrudniejszy punkt ruchu. W pozycji końcowej można zatrzymać na chwilę ciężar dla lepszego ukrwienia mięśnia, ale pod warunkiem utrzymania bicepsów w pełnym napięciu. Należy pamiętać, że ruch opuszczania musi być w pełni kontrolowany i wolniejszy od unoszenia. Do ćwiczenia można używać zarówno sztangi prostej, jak i łamanej - gryf łamany zmniejsza napięcia powstające w nadgarstkach."));
        ArmsList.add(new SpinnerListItem("Uginanie ramion ze sztangą na modlitewniku",
                "Mięśnie dwugłowe ramion, mięśnie ramienne, mięśnie ramienno-promieniowe.",
                "Siadamy na siodełku modlitewnika. Nogi rozstawiamy w taki sposób, by pozwoliły nam utrzymać stabilną pozycję. Górna krawędź modlitewnika powinna znaleźć się pod naszymi pachami. Ramiona rozstawione na szerokość barków - równolegle do siebie. Rozstaw dłoni - w zależności od celu ćwiczenia. Zakres ruchu: od pełnego rozgięcia bicepsów (nie ramion) do pełnego ich skurczu, przy czym przedramiona nie powinny przekraczać linii pionu. Pełne rozciągnięcie bicepsów, to nie to samo, co pełny wyprost ramion. Należy unikać tzw. ”przeprostów” ramion, czyli nadmiernego ich wyprostowywania (do pełnego zakresu ruchu w stawie łokciowym). Faza negatywna ruchu - prostowanie ramion powinna odbywać się przy pełnej kontroli ciężaru. Opuszczamy sztangę wolniej niż unosimy. Do ćwiczenia można używać zarówno sztangi prostej, jak i łamanej - gryf łamany zmniejsza napięcia powstające w nadgarstkach."));
        ArmsList.add(new SpinnerListItem("Uginanie ramion ze sztangielkami w siadzie na ławce skośnej (z supinacją nadgarstka)",
                "Mięśnie dwugłowe ramion, mięśnie ramienne, mięśnie przedramion, mięśnie ramienno-promieniowe.",
                " Ćwiczenie trzeba wykonywać z dużą koncentracją. Siadamy na ławce skośnej, o nachyleniu ok. 45 stopni. Przedramiona powinny być lekko odchylone od tułowia, a łokcie przylegać do niego. Wymodelowaniu kształtu mięśni służy „supinacja” nadgarstka. Polega ona na stopniowym obracaniu dłoni w trakcie wykonywania ćwiczenia. W pozycji wyjściowej (ramiona wyprostowane) dłonie zwrócone są ku sobie palcami, a w miarę uginania ramion obracają się tak, by w końcowym momencie ruchu (przy zgiętych ramionach) małe palce były wyżej od kciuków. Wskazane dla lepszego rozwoju bicepsów jest zatrzymanie ruchu w końcowym położeniu i maksymalne napięcie mięśni przez 1-3 sekundy. Ruch można wykonywać na przemian - raz jedna ręka, raz druga (po 1 powtórzeniu), obiema rękami jednocześnie lub opuszczając jedną rękę jednocześnie unosząc drugą."));
        ArmsList.add(new SpinnerListItem("Uginanie ramienia ze sztangielką w siadzie - w podporze o kolano",
                "Mięśnie dwugłowe ramion, mięśnie ramienne, mięśnie przedramion.",
                "Ćwiczenie wymaga dużej koncentracji w czasie wykonywania. Siadamy na ławce lub krześle, pochylamy się lekko do przodu. Chwytamy sztangielkę w dłoń i opieramy łokieć o wewnętrzną część uda. Ruch powinien mieć wolne tempo (zarówno podczas unoszenia i opuszczania) - jest to ćwiczenie koncentryczne i technika jest w nim ważniejsza od wielkości ciężaru. Można również w tym ćwiczeniu stosować supinację nadgarstka. Ramiona „zamykamy” do końca, napinając maksymalnie mięsień. Prostujemy ramię (jak w innych ćwiczeniach na mięśnie dwugłowe) tylko do momentu pełnego rozciągnięcia bicepsów, nie do pełnego zakresu ruchu w stawie łokciowym."));
        ArmsList.add(new SpinnerListItem("Ściąganie ciężaru na wyciągu",
                "Triceps.","Stajemy przed wyciągiem, dopieramy odpowiedni gryf i w pozycji lekko pochylonej ściągamy gryf w dół. Łokcie cały czas przy tułmowiu."));

        /**
         * Inicjalizacja listy ćwiczeń na Brzuch
         */
        AbsList.add(new SpinnerListItem(null,null,null));
        AbsList.add(new SpinnerListItem("Skłony w leżeniu na płasko",
                "mięśnie proste brzucha, skośne brzucha.","Kładziemy się na ziemi. Nogi ugięte, ręce nad głową i unosimy tułów do góry, ale nie odrywając dolnego odcinka pleców, wystarczy aby łopatki się oderwały." +
                "Jeżeli chcemy zaangażować skośne mięśnie brzucha, nie kładziemy się na ziemi tylko pochylamy tworząc z podłożem kąt 40 stopni, i skręcamy tułów[można dodać ciężar]."));
        AbsList.add(new SpinnerListItem("Unoszenie nóg w leżeniu",
                "mięśnie proste brzucha, skośne brzucha. ","Kładziemy się na ziemi, unosimy nogi proste nad głowę, i wracamy powoli."));
        AbsList.add(new SpinnerListItem("Deska","Wszystkie mięsnie brzucha",
                "Ustawiamy się w pozcji do deski(czyli tak jak do pompek ale na łokciach). Po czym trzymamy taką pozycję przez pewien czas(10/20/30 sekund). Jeżeli jesteśmy w stanie wytrzymać minutę nie zwiększamy czasu, a ilość powtózeń"));

        /**
         * Inicjalizacja listy ćwiczeń na Nogi
         */
        LegList.add(new SpinnerListItem(null,null,null));
        LegList.add(new SpinnerListItem("Przysiady ze sztangą na barkach",
                "głowy boczne, pośrednie i przyśrodkowe mięśni czworogłowych ud.",
                "Ćwiczenie to można wykonywać zarówno ze sztangą, jak i sztangielkami. Wchodzimy pod sztangę stojącą na stojakach, barki opuszczone i odwiedzione w tył, gryf sztangi dotyka naszego karku na mięśniach czworobocznych grzbietu (ich górnej części), dłonie rozstawione w wygodnej i stabilnej pozycji na gryfie, klatka wypchnięta ku przodowi, naturalna krzywizna kręgosłupa - dolny odcinek grzbietu wypchnięty do przodu, rozstaw stóp w zależności od naszego poczucia stabilności (zmiana rozstawu stóp powodować będzie atak na mięśnie pod innym kątem), najlepiej nieco szerzej niż barki, całe stopy przylegają do podłogi, ciężar ma opierać się na piętach, głowa zadarta nieco do tyłu. Z tej pozycji nabieramy głęboko powietrza i ściągamy sztangę ze stojaków i rozpoczynamy ruch w dół (najlepiej przed tym wypuszczając powietrze po ściąganiu sztangi ze stojaków i nabierając go ponownie). Przez cały czas plecy wygięte w jednakowy sposób, pracują tylko nogi. Najlepiej, gdy przez cały czas biodra i pięty znajdują się w jednej linii, nie wypychamy kolan do przodu (nie powinny wysuwać się dalej niż końce palców stóp). Schodzimy w dół do momentu, gdy zanika kontrola pracy mięśni czworogłowych, a ich rozciągnięcie jest maksymalne. Rozpoczynamy powrót do pozycji wyjściowej, wypychając się piętami podnosimy się w górę, jednocześnie wypychając biodra w przód, aż do pozycji startowej"));
        LegList.add(new SpinnerListItem("Wykroki",
                "Przywodziciele krótkie i wielkie, w mniejszym stopniu głowy boczne, pośrednie i przyśrodkowe mięśni czworogłowych ud."," Pozycja wyjściowa taka, jak przy przysiadach zwykłych. Z tej pozycji stawiamy jedną noga krok do przodu (na tyle duży, by po wykonaniu przysiadu do momentu ugięcia nogi pod kątem 90 stopni-podudzia były prostopadle do podłogi, a uda równoległe), po czym wykonujemy na nodze wykrocznej przysiad, na tyle głęboki, by noga ugięła się pod kątem ok.90 stopni. Po czy wracamy do pozycji wyjściowej i wykonujemy to samo, ale drugą nogą. Noga nie ćwiczona w trakcie przysiadu lekko ugięta w kolanie, a w trakcie, gdy noga wykroczna jest wysunięta do przodu - czasowo przylega do podłogi tylko palcami (noga nie trenowana)."));
        LegList.add(new SpinnerListItem("Wspięcia na palce w staniu",
                "Obie głowy mięśni brzuchatych łydek","Ćwiczenie to można wykonywać przy pomocy sztangi, ale również bez obciążenia, a także jednonóż. Sztangę można również zastąpić sztangielką trzymaną w dłoni (po tej samej stronie, co ćwiczona noga: lewa noga - lewa ręka, prawa noga - prawa ręka). Istotnym elementem w tym ćwiczeniu jest użycie grubej podkładki pod palce stóp, która pozwala zwiększyć znacznie zakres ruchu, a co za tym idzie - poprawić efektywność ćwiczenia. Pozycja wyjściowa, to wyprostowany tułów i plecy, nogi wyprostowane w kolanach, rozkrok 25-30 cm, palce stóp (wraz ze stawami łączącymi je ze śródstopiem) na podkładce - mięśnie łydek rozciągnięte maksymalnie. Z takiej pozycji rozpoczynamy wspięcia. Ruch powinien być wolny i dokładny, ze stałym „czuciem” pracy mięśni. Należy unikać odbijania się pięt od podłogi."));
        LegList.add(new SpinnerListItem("Wyciskanie nogami na maszynie",
                "głowy boczne, pośrednie i przyśrodkowe mięśni czworogłowych ud.","Wyciskanie nóg na maszynie. Nie jest to zbyt skomplikowane. Należy jedynie unikać aby nie prostować nóg do końca."));
    }
}

