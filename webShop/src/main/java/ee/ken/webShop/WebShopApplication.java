package ee.ken.webShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

}
// console-s
// ssl --> setrigfikaadi viga : http/https
//ERR_CONNECTION_REFUSED --> back-end ei tööta
//Failed to fetch --> Network tab- alt

// 400 --> Üldine front-end viga. Viga pole võimalik täpsemalt kirjeldada. nt Body on puudu vms
// 404 --> URL vale, endpoint. API otspunkt. localhost:8080/categories on valesti kirjutatud
// 405 --> API otspunkt on õige, aga ei saa Method-it teha. GET-POST-PUT
// 415 --> Body on valel kujul,saadame nt kogemata json kuju asemel stringi. Headerid kuju muutmiseks on puudu.
// 5xx --> back-end viga. Kõik 4ga algavad on päringu tegija viga, 5ga algav on serveripoolne viga.
// 200 --> õnnestuv päring

// Kodus MaintainImage ja MaintainShops kohta samad asjad mis  sai tehtud producti ja category kohta.
//ImageController ja ShopController. Shopi jaoks locationi pole vaja seekord veel pusima hakata.

// 17.12/20.12 : 9.00
// 24.12/25.12 : 9.00
// 30.12/02/01 : 9.00