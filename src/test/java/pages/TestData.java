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
    @DataProvider(name = "EmailStandardPlanButtonsData")
    public static Object[][] EmailStandardPlanButtonsDataProvider() {

        return new Object[][] {
                {0, "Swisscows.email Standard", "https://accounts.dev.swisscows.com/products/swisscows-email-standard/buy?planId=monthly"},
                {1, "Swisscows.email Standard","https://accounts.dev.swisscows.com/products/swisscows-email-standard/buy?planId=annual"},

        };
    }
    @DataProvider(name = "PlatinumLinksData")
    public static Object[][] PlatinumLinksDataProvider() {

        return new Object[][] {
                {0, "Swisscows.email Premium", "https://accounts.dev.swisscows.com/products/swisscows-email-premium"},
                {1, "Swisscows.VPN Standard","https://accounts.dev.swisscows.com/products/swisscows-vpn-standard"},

        };
    }
    @DataProvider(name = "VpnStandardPlanButtonsData")
    public static Object[][] VpnStandardPlanButtonsDataProvider() {

        return new Object[][] {
                {0, "Swisscows.VPN Standard", "https://accounts.dev.swisscows.com/products/swisscows-vpn-standard/buy?planId=monthly"},
                {1, "Swisscows.VPN Standard","https://accounts.dev.swisscows.com/products/swisscows-vpn-standard/buy?planId=annual"},

        };
    }
    @DataProvider(name = "PlatinumPlanButtonsData")
    public static Object[][] PlatinumPlanButtonsDataProvider() {

        return new Object[][] {
                {0, "Swisscows Platinum", "https://accounts.dev.swisscows.com/products/swisscows-platinum/buy?planId=monthly"},
                {1, "Swisscows Platinum","https://accounts.dev.swisscows.com/products/swisscows-platinum/buy?planId=annual"},

        };
    }
    @DataProvider(name = "EmailPremiumPlanButtonsData")
    public static Object[][] EmailPremiumPlanButtonsDataProvider() {

        return new Object[][] {
                {0, "Swisscows.email Premium", "https://accounts.dev.swisscows.com/products/swisscows-email-premium/buy?planId=monthly"},
                {1, "Swisscows.email Premium","https://accounts.dev.swisscows.com/products/swisscows-email-premium/buy?planId=annual"},

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
                {0, "Login - Swisscows Accounts","Login"},
                {1, "Swisscows.VPN Standard - Swisscows Accounts","Swisscows.VPN Standard"},
                {2, "Swisscows.email Premium - Swisscows Accounts","Swisscows.email Premium"},
                {3, "Your private and anonymous search engine Swisscows","search engine Swisscows"},
                {4, "Your Profile - Swisscows Accounts","Your Profile"}


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
