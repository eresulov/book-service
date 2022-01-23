package homework3;
public class main {
public static void main(String[] emral) {
	Person eresulov=new Person();
	Person nbagirov=new Person();
	Person cnaibov=new Person();
	eresulov.id=190101005;
	eresulov.name="Emral";
	eresulov.surnime="Resulov";
	eresulov.address="Genclik";
    eresulov.phone="0708788867";
    eresulov.email="eresulov@std.beu.edu.az";
    eresulov.gender="male";
    eresulov.country="Azerbaijan";
    eresulov.age=19;
    eresulov.hashome=true;
    eresulov.hascar=false;
    nbagirov.id=190101023;
    nbagirov.name="Nurlan";
    nbagirov.surnime="Bagirov";
    nbagirov.address="Nerimanov";
    nbagirov.phone="0777777777";
    nbagirov.email="nbagirov@std.beu.edu.az";
    nbagirov.gender="male";
    nbagirov.country="Azerbaijan";
    nbagirov.age=26;
    nbagirov.hashome=true;
    nbagirov.hascar=true;
    cnaibov.id=190101001;
    cnaibov.name="Cavid";
    cnaibov.surnime="Naibov";
    cnaibov.address="Masazir";
    cnaibov.phone="0556878743";
    cnaibov.email="cnaibov@std.beu.edu.az";
    cnaibov.gender="male";
    cnaibov.country="Azerbaijan";
    cnaibov.age=22;
    cnaibov.hashome=false;
    cnaibov.hascar=false;
    
    eresulov.printinformation();
    nbagirov.printinformation();
    cnaibov.printinformation();
}
}