package pages;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "RegisterPageLinksData")
    public static Object[][] RegisterPageLinksDataDataProvider() {

        return new Object[][] {
                {0, "Swisscows Privacy Policy", "https://swisscows.com/en/privacy"},
                {1, "General terms and conditions","https://swisscows.com/en/gtc"},
                {2, "Cookies Policy","https://swisscows.com/en/cookies"},


        };
    }
    @DataProvider(name = "WelcomePageLinksData")
    public static Object[][] WelcomePageLinksDataProvider() {

        return new Object[][] {
                {0, "A letter is your personal property!", "https://swisscows.com/en/swisscows-email"},
                {1, "SCREENSHOTS","https://teleguard.com/en"},
                {2, "Anonymous web surfing with Swisscows","https://swisscows.com/en/anonymous-vpn"},


        };
    }
    @DataProvider(name = "LangRegisterPageTestData")
    public static Object[][] LangRegisterPageDataProvider() {

        return new Object[][]{
                {0,  "Registrieren - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=de"},
                {1,  "Registrarse - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=es"},
                {2,  "S'inscrire - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=fr"},
                {3,  "Registrarsi - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=it"},
                {4,  "Reģistrēties - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=lv"},
                {5,  "Registreren - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=nl"},
                {6,  "Regisztráció - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=hu"},
                {7,  "Registrar - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=pt"},
                {8,  "Регистрация - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=ru"},
                {9,  "Реєстрація - Swisscows Accounts","https://accounts.dev.swisscows.com/register?culture=uk"},


        };
    }
    @DataProvider(name = "LangLoginPageTestData")
    public static Object[][] LangLoginPageDataProvider() {

        return new Object[][]{
                {0, "Login", "https://accounts.dev.swisscows.com/login?culture=de"},
                {1, "Iniciar sesión", "https://accounts.dev.swisscows.com/login?culture=es"},
                {2, "Connexion", "https://accounts.dev.swisscows.com/login?culture=fr"},
                {3, "Login", "https://accounts.dev.swisscows.com/login?culture=it"},
                {4, "Pieslēgties", "https://accounts.dev.swisscows.com/login?culture=lv"},
                {5, "Log in", "https://accounts.dev.swisscows.com/login?culture=nl"},
                {6, "Jelentkezzen be", "https://accounts.dev.swisscows.com/login?culture=hu"},
                {7, "Conecte-se", "https://accounts.dev.swisscows.com/login?culture=pt"},
                {8, "Логин", "https://accounts.dev.swisscows.com/login?culture=ru"},
                {9, "Логін", "https://accounts.dev.swisscows.com/login?culture=uk"},


        };
    }
    @DataProvider(name = "LangProfilePageTestData")
    public static Object[][] LangProfilePageDataProvider() {

        return new Object[][]{
                {1, "Ihr Profil"},
                {2, "Tu perfil"},
                {3, "Votre profil"},
                {4, "Il tuo profilo"},
                {5, "Tavs profils"},
                {6, "Je profiel"},
                {7, "Profilod"},
                {8, "Seu perfil"},
                {9, "Ваш профиль"},
                {10, "Ваш профіль"},
                {0, "Your Profile"},


        };
    }
        @DataProvider(name = "LangForgotPageTestData")
        public static Object[][] LangForgotPageDataProvider() {

            return new Object[][]{
                    {0, "Account wiederherstellen", "https://accounts.dev.swisscows.com/forgot?culture=de"},
                    {1, "Recuperar cuenta", "https://accounts.dev.swisscows.com/forgot?culture=es"},
                    {2, "Récupérer le compte", "https://accounts.dev.swisscows.com/forgot?culture=fr"},
                    {3, "Recuperare conto", "https://accounts.dev.swisscows.com/forgot?culture=it"},
                    {4, "Atjaunot kontu", "https://accounts.dev.swisscows.com/forgot?culture=lv"},
                    {5, "Account herstellen", "https://accounts.dev.swisscows.com/forgot?culture=nl"},
                    {6, "Fiók helyreállítása", "https://accounts.dev.swisscows.com/forgot?culture=hu"},
                    {7, "Recuperar a conta", "https://accounts.dev.swisscows.com/forgot?culture=pt"},
                    {8, "Восстановить аккаунт", "https://accounts.dev.swisscows.com/forgot?culture=ru"},
                    {9, "Відновити акаунт", "https://accounts.dev.swisscows.com/forgot?culture=uk"},


            };
        }


    @DataProvider(name = "TopMenuTestData")
    public static Object[][] topMenuTestDataProvider() {

        return new Object[][]{
                {0, "Set as Startpage", "/en/set-as-startpage", "https://dev.swisscows.com/en/set-as-startpage"},
                {1, "Make a Default Search Engine", "/en/default-search", "https://dev.swisscows.com/en/default-search"},
                {2, "Who we are", "/en/search-engine-no-tracking", "https://dev.swisscows.com/en/search-engine-no-tracking"},
                {3, "Media Education", "/en/media-education", "https://dev.swisscows.com/en/media-education"},
                {4, "Charity Project", "/en/social-projects", "https://dev.swisscows.com/en/social-projects"},
                {5, "Our Datacenter", "/en/data-safe-search-engine", "https://dev.swisscows.com/en/data-safe-search-engine"},
                {6, "Contact us", "/en/contact", "https://dev.swisscows.com/en/contact"},
                {7, "Data privacy", "/en/privacy", "https://dev.swisscows.com/en/privacy"},
                {8, "Donation", "/en/donation", "https://dev.swisscows.com/en/donation"},

        };
    }

    @DataProvider(name = "LangTopMenuTestData")
    public static Object[][] LangTestDataProvider() {

        return new Object[][]{
                {1, "Deutsch", "https://dev.swisscows.com/de","Deine private und anonyme Suchmaschine Swisscows"},
                {2, "Español", "https://dev.swisscows.com/es", "Su buscador privado y anónimo Swisscows"},
                {3, "Français", "https://dev.swisscows.com/fr", "Votre moteur de recherche privé et anonyme Swisscows"},
                {4, "Italiano", "https://dev.swisscows.com/it", "Il tuo motore di ricerca privato e anonimo Swisscows"},
                {5, "Latviešu", "https://dev.swisscows.com/lv", "Jūsu privātā un anonīma meklētājprogramma Swisscows"},
                {6, "Magyar", "https://dev.swisscows.com/hu", "Az Ön privát és névtelen keresőmotorja, Swisscows"},
                {7, "Nederlands", "https://dev.swisscows.com/nl", "Uw privé en anonieme zoekmachine Swisscows"},
                {8, "Portugal", "https://dev.swisscows.com/pt", "O teu motor de busca privado e anónimo Swisscows"},
                {9, "Русский", "https://dev.swisscows.com/ru", "Swisscows - Ваша приватная и анонимная поисковая система"},
                {10, "Українська", "https://dev.swisscows.com/uk", "Swisscows - Ваша приватна та анонімна пошукова система"},


        };
    }
    @DataProvider(name = "LangSetAsStartTestData")
    public static Object[][] LangSetAsStartDataProvider() {

        return new Object[][]{
                {1, "Deutsch", "Swisscows als Startseite festlegen"},
                {2, "Español", "Establecer Swisscows como página de inicio"},
                {3, "Français",  "Utiliser Swisscows comme page d'accueil"},
                {6, "Magyar",  "How to set Swisscows as your start page"},
                {7, "Nederlands",  "How to set Swisscows as your start page"},


        };
    }
    @DataProvider(name = "LangMakaDefaultSearchTestData")
    public static Object[][] LangMakaDefaultSearchDataProvider() {

        return new Object[][]{
                {1, "Deutsch", "Standardsuche verwenden"},
                {2, "Español", "Use la búsqueda estándar"},
                {3, "Français",  "Utiliser la recherche par défaut"},
                {6, "Magyar",  "Használja a Swisscows-t alapértelmezett keresőként"},
                {7, "Nederlands",  "How to use Swisscows as default search"},

        };
    }

    @DataProvider(name = "RegionTopMenuTestData")
    public static Object[][] RegionTestDataProvider() {

        return new Object[][]{
                {0, "Argentina", "https://dev.swisscows.com/en?region=es-AR","Your private and anonymous search engine Swisscows"},
                {1, "Australia", "https://dev.swisscows.com/en?region=en-AU", "Your private and anonymous search engine Swisscows"},
                {2, "Austria", "https://dev.swisscows.com/en?region=de-AT", "Your private and anonymous search engine Swisscows"},
                {3, "Belgium(fr)", "https://dev.swisscows.com/en?region=fr-BE", "Your private and anonymous search engine Swisscows"},
                {6, "Canada(en)", "https://dev.swisscows.com/en?region=en-CA", "Your private and anonymous search engine Swisscows"},
                {7, "Canada(fr)", "https://dev.swisscows.com/en?region=fr-CA", "Your private and anonymous search engine Swisscows"},
                {12, "France", "https://dev.swisscows.com/en?region=fr-FR", "Your private and anonymous search engine Swisscows"},
                {13, "Germany", "https://dev.swisscows.com/en?region=de-DE", "Your private and anonymous search engine Swisscows"},
                {18, "Italy", "https://dev.swisscows.com/en?region=it-IT", "Your private and anonymous search engine Swisscows"},
                {37, "Switzerland(de)", "https://dev.swisscows.com/en?region=de-CH", "Your private and anonymous search engine Swisscows"},
                {38, "Switzerland(fr)", "https://dev.swisscows.com/en?region=fr-CH", "Your private and anonymous search engine Swisscows"},
                {45, "World-wide", "https://dev.swisscows.com/en?region=iv", "Your private and anonymous search engine Swisscows"},

        };
    }

    @DataProvider(name = "ExternalTopMenuTestData")
    public static Object[][] externalTopMenuTestDataProvider() {

        return new Object[][]{
                {8, "Blog", "https://dev.swisscows.com/en/privacy", "https://dev.swisscows.com/en/privacy", "Blog "},
                {9, "For Business", "https://dev.swisscows.com/en/privacy", "https://dev.swisscows.com/en/privacy", "for business"}
        };
    }


    @DataProvider(name = "FooterMenuData")
    public static Object[][] footerMenuTestDataProvider() {

        return new Object[][] {
                {0, "Who we are", "/en/search-engine-no-tracking", "https://dev.swisscows.com/en/search-engine-no-tracking", "The search engine without tracking – Swisscows"},
                {1, "Media Education", "/en/media-education", "https://dev.swisscows.com/en/media-education", "Swisscows – media education"},
                {2, "Charity Project", "/en/social-projects", "https://dev.swisscows.com/en/social-projects", "Charity Project"},
                {3, "Our Datacenter", "/en/data-safe-search-engine", "https://dev.swisscows.com/en/data-safe-search-engine", "Data secure search engine"},
                {4, "Contact us", "/en/contact", "https://dev.swisscows.com/en/contact", "Contact us"},
                {5, "VPN", "/en/anonymous-vpn", "https://dev.swisscows.com/en/anonymous-vpn", "Anonymous web surfing with Swisscows"},
                {6, "Swisscows.email", "/en/swisscows-email", "https://dev.swisscows.com/en/swisscows-email", "A letter is your personal property!"},
                {12, "Set as Startpage", "/en/set-as-startpage", "https://dev.swisscows.com/en/set-as-startpage", "How to set Swisscows as your start page"},
                {13, "Make a Default Search Engine", "/en/default-search", "https://dev.swisscows.com/en/default-search", "How to use Swisscows as default search"},


        };
    }
    @DataProvider(name = "WhoWeAreLinksData")
    public static Object[][] WhoWeAreLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows", "/en", "https://dev.swisscows.com/en", "Anonymous search engine"},
                {1, "privacy policy", "/en/privacy", "https://dev.swisscows.com/en/privacy", "Swisscows Privacy Policy"},

        };
    }
    @DataProvider(name = "CookiesLinksData")
    public static Object[][] CookiesLinksTestDataProvider() {

        return new Object[][] {
                {0, "https://accounts.swisscows.com/login?ReturnUrl=%2F", "Login"},
                {1, "https://swisscows.com/en/privacy", "Swisscows Privacy Policy"},
                {2, "https://accounts.swisscows.com/login?ReturnUrl=%2F", "Login"},
                {3, "https://swisscows.com/en/contact", "Contact us"}

        };
    }
    @DataProvider(name = "GtcLinksData")
    public static Object[][] GtcLinksTestDataProvider() {

        return new Object[][] {
                {0, "https://swisscows.com/en/gtc#services", "General terms and conditions"},
                {1, "https://swisscows.com/en/gtc#setup", "General terms and conditions"},
                {2, "https://swisscows.com/en/gtc#info", "General terms and conditions"},
                {3, "https://swisscows.com/en/gtc#payment", "General terms and conditions"},
                {4, "https://swisscows.com/en/gtc#restriction", "General terms and conditions"},
                {5, "https://swisscows.com/en/gtc#property", "General terms and conditions"},
                {6, "https://swisscows.com/en/gtc#actions", "General terms and conditions"},
                {7, "https://swisscows.com/en/gtc#guideline", "General terms and conditions"},
                {8, "https://swisscows.com/en/gtc#license", "General terms and conditions"},
                {9, "https://swisscows.com/en/gtc#links", "General terms and conditions"},
                {10, "https://swisscows.com/en/gtc#liability", "General terms and conditions"},
                {11, "https://swisscows.com/en/gtc#sla", "General terms and conditions"},
                {12, "https://swisscows.com/en/gtc#compensation", "General terms and conditions"},
                {13, "https://swisscows.com/en/gtc#modification-services", "General terms and conditions"},
                {14, "https://swisscows.com/en/gtc#law", "General terms and conditions"},
                {15, "https://swisscows.com/en/gtc#requests", "General terms and conditions"},
                {16, "https://swisscows.com/en/gtc#questions", "General terms and conditions"},
                {17, "https://swisscows.com/en/privacy", "Swisscows Privacy Policy"},
                {18, "https://swisscows.com/en/privacy", "Swisscows Privacy Policy"},


        };
    }
    @DataProvider(name = "DashboardLinksDataExternalUser")
    public static Object[][] DashboardLinksTestDataProviderExternalUser() {

        return new Object[][] {
                {0, "https://accounts.dev.swisscows.com/products/swisscows-vpn-standard", "Swisscows.VPN Standard"},
                {1, "https://swisscows.com/en", "Anonymous search engine"},
                {2, "https://accounts.dev.swisscows.com/profile", "Your Profile"}


        };
    }
    @DataProvider(name = "DashboardLinksDataSwisscowsUser")
    public static Object[][] DashboardLinksTestDataProviderSwisscowsUser () {

        return new Object[][] {
                {0, "Login"},
                {1, "Swisscows.VPN Standard"},
                {2, "Swisscows.email Premium"},
                {3, "Anonymous search engine"},
                {4, "Your Profile"}


        };
    }

    @DataProvider(name = "VpnLinksData")
    public static Object[][] VpnLinksTestDataProvider() {

        return new Object[][] {
                {0,"https://accounts.swisscows.com/register", "Register"},
                {1, "https://chrome.google.com/webstore/detail/swisscowsvpn/nglddggbgngenfgaelmmmhldofddjlmh", "chrome web store"},
                {2, "https://addons.mozilla.org/en-US/firefox/addon/swisscows-vpn/", "Swisscows.VPN\nby Swisscows AG"},
                {3, "https://dev.swisscows.com/en/vpn-instruction", "Configuring Swisscows Proxy"},
                {4, "https://accounts.swisscows.com/login?ReturnUrl=%2Fproducts%2Fswisscows-vpn-standard", "Login"},
                {5, "https://accounts.swisscows.com/login?ReturnUrl=%2Fproducts%2Fswisscows-vpn-standard", "Login"},

        };
    }
    @DataProvider(name = "EmailLinksData")
    public static Object[][] EmailLinksTestDataProvider() {

        return new Object[][] {
                {0, "Login - Swisscows Accounts"},
                {1, "Login - Swisscows Accounts"},
                {2, "Login - Swisscows Accounts"},


        };
    }
    @DataProvider(name = "ServicesBlockLinksData")
    public static Object[][] ServicesBlockLinksDataDataProvider() {

        return new Object[][] {
                {0, "Enterprise Search Software for companies", "https://hesbox.com/en"},
                {1, "Swisscows Fanshop für Kleider und Geschenke für Fans","https://swisscows-fanshop.com/"},
                {2, "Blog - Andreas Wiebe","https://awiebe.org/"},


        };
    }

    @DataProvider(name = "CharityProjectLinksData")
    public static Object[][] CharityProjectLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows VPN", "/en/vpn", "https://dev.swisscows.com/en/anonymous-vpn",},
                {1, "TeleGuard", "https://teleguard.com", "https://teleguard.com/en"},

        };
    }
    @DataProvider(name = "MakeDefaultSearchLinksData")
    public static Object[][] MakeDefaultSearchLinksTestDataProvider() {

        return new Object[][] {
                {0, "Install Swisscows", "https://addons.mozilla.org/en-US/firefox/addon/swisscows-search/", "https://addons.mozilla.org/en-US/firefox/addon/swisscows-search/",},
                {1, "Install Swisscows", "https://chrome.google.com/webstore/detail/swisscows/ibimaeimnogcdnjmmlpodbhhbejnpaij", "https://chrome.google.com/webstore/detail/swisscows/ibimaeimnogcdnjmmlpodbhhbejnpaij"},
                {2, "Install Swisscows", "https://swisscows.com/web?query=%s", "https://swisscows.com/en/web?query=%25s"},
                {3, "Install Swisscows", "https://swisscows.com/web?query=%s", "https://swisscows.com/en/web?query=%25s"},
                {4, "Install Swisscows", "https://microsoftedge.microsoft.com/addons/detail/swisscows/dlclfmjmfabgglmifagcjnjcpimekdmn", "https://microsoftedge.microsoft.com/addons/detail/swisscows/dlclfmjmfabgglmifagcjnjcpimekdmn"},
        };
    }

    @DataProvider(name = "OurDatacenterLinksData")
    public static Object[][] OurDatacenterLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows.com", "/en", "https://dev.swisscows.com/en",},
                {1, "Media Education", "/en/media-education", "https://dev.swisscows.com/en/media-education"},

        };
    }
    @DataProvider(name = "DonationLinksData")
    public static Object[][] DonationLinksTestDataProvider() {

        return new Object[][] {
                {0, "Swisscows VPN", "/en/anonymous-vpn", "https://dev.swisscows.com/en/anonymous-vpn","Anonymous web surfing with Swisscows"},
                {1, "TeleGuard", "https://teleguard.com", "https://teleguard.com/en","SCREENSHOTS"},
                {2, "here", "/en/social-projects", "https://dev.swisscows.com/en/social-projects","Charity Project"},

        };
    }


    @DataProvider(name = "ExternalFooterMenuData")
    public static Object[][] externalMenuTestDataProvider() {

        return new Object[][] {
                {7, "TeleGuard", "https://teleguard.com", "https://teleguard.com/en", "TeleGuard - secure messenger from Switzerland"},
                {8, "HES", "https://hesbox.com/", "https://hesbox.com/en", "Enterprise Search Software for companies"},
                {9, "GetDigest", "https://getdigest.com/", "https://getdigest.com/en", "GetDigest | Get a document summary. Fast!"},
                {10, "Fan-shop", "https://swisscows-fanshop.com", "https://swisscows-fanshop.com/", "Swisscows Fanshop für Kleider und Geschenke für Fans"},
                {11, "Swisscows Blog", "https://blog.swisscows.com/", "https://blog.swisscows.com/", "Blog - Swisscows AG"},



        };
    }
    @DataProvider(name = "ExternalFooterSearchMenuData")
    public static Object[][] externalMenuTestDataProviderFooterSearch() {

        return new Object[][] {
                {0, "Learn more about", "https://company.swisscows.com/en", "https://company.swisscows.com/en", "Swisscows AG |Startpage"},
                {6, "googlePlay", "https://play.google.com/store/apps/details?id=com.swisscows.search", "https://play.google.com/store/apps/details?id=com.swisscows.search", "Swisscows Private Search - Apps on Google Play"},
                {7, "appStore", "https://apps.apple.com/app/swisscows-privacy-search/id1581108092", "https://apps.apple.com/app/swisscows-privacy-search/id1581108092", "Swisscows Private Search on the App Store"},



        };
    }

    @DataProvider(name = "SignInCredentials")
    public static Object[][] signInWithInvalidCredentialsTestDataProvider() {

        return new Object[][] {
                {"bothWrong", "jka59435@xcoxc.com", "Tester11#", "Invalid Email or password.", "Sign In"},
                {"invalidEmail", "jka59435@xcoxc.com", "Tester12#", "Invalid Email or password.", "Sign In"},
                {"invalidPassword", "jka59433@xcoxc.com", "Tester11#", "Invalid Email or password.", "Sign In"},
                {"bothEmpty", "", "", "Invalid Email or password.", "Sign In"},
                {"emptyEmail", "", "Tester12#", "Invalid Email or password.", "Sign In"},
                {"emptyPassword", "jka59433@xcoxc.com", "", "Invalid Email or password.", "Sign In"},
                {"passwordCaseSensitive", "jka59433@xcoxc.com", "tester12#", "Invalid Email or password.", "Sign In"},
                {"passwordLeadingSpace", "jka59433@xcoxc.com", " Tester12#", "Invalid Email or password.", "Sign In"},
                {"passwordTrailingSpace", "jka59433@xcoxc.com", "Tester12# ", "Invalid Email or password.", "Sign In"}
        };
    }
}
