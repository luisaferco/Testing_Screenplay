package co.com.webapps.screenplay.stepdefinitions.linio;


import co.com.webapps.screenplay.interactions.AddToCart;
import co.com.webapps.screenplay.interactions.OpenCategories;
import co.com.webapps.screenplay.interactions.ScrollBy;
import co.com.webapps.screenplay.interactions.builders.GoTo;
import co.com.webapps.screenplay.interactions.sums.Save;
import co.com.webapps.screenplay.models.Article;
import co.com.webapps.screenplay.questions.ListOfProducts;
import co.com.webapps.screenplay.questions.Prices;
import co.com.webapps.screenplay.questions.SubTotal;
import co.com.webapps.screenplay.questions.TextOf;
import co.com.webapps.screenplay.tasks.Add;
import co.com.webapps.screenplay.tasks.Adds;

import co.com.webapps.screenplay.tasks.Clean;
import co.com.webapps.screenplay.tasks.filters.builder.Filters;
import co.com.webapps.screenplay.userinterfaces.DetailsArticlePage;
import co.com.webapps.screenplay.userinterfaces.InitPage;
import co.com.webapps.screenplay.userinterfaces.ShoppingCartPage;
import co.com.webapps.screenplay.utils.enums.CategoriesEnum;
import co.com.webapps.screenplay.utils.enums.SectionsEnum;
import co.com.webapps.screenplay.utils.smart.DataDriven;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static co.com.webapps.screenplay.utils.StringManager.FIRST;
import static co.com.webapps.screenplay.utils.StringManager.priceToInteger;
import static co.com.webapps.screenplay.utils.enums.CategoriesEnum.CONSOLES_AND_VIDEO_GAMES;
import static co.com.webapps.screenplay.utils.enums.PagesEnum.LINIO_PAGE;
import static co.com.webapps.screenplay.utils.enums.TypeSort.LOWER_PRICE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;


public class AddToCartStepDefinition {
    

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("(.*) enters to at the Linio web store")
    public void tinaEntersToAtTheLinioWebStore(String name) {
       OnStage.theActor(name).attemptsTo(GoTo.Page(LINIO_PAGE));
    }

    @When("she add products from consoles and video games category")
    public void sheSearchProductFromConsolesAndVideoGamesCategory() {
        theActorInTheSpotlight().attemptsTo(Adds.articles(DataDriven.getListArticles())
                        .fromCategory(CONSOLES_AND_VIDEO_GAMES)
                         ,GoTo.shoppingCart());
    }



    @Then("she should see all products on shopping cart")
    public void sheShouldSeeAllProductsOnShoppingCart() {
        List<String> selectedProductsList = theActorInTheSpotlight().recall("listOfProducts");
        selectedProductsList.forEach(product-> theActorInTheSpotlight().should(seeThat(ListOfProducts.inShoppingCart(),
               (hasItem(containsString(product))))));
       
    }

    @When("she adds the products from sport category into Motorsports section")
    public void sheLooksForTheTulaMotoImpermeableDryBagFromSportCategoryIntoMotorsportsSection(List<Article> listArticles) {
        theActorInTheSpotlight().attemptsTo(
                OpenCategories.onCategory(CategoriesEnum.SPORTS).andSection(SectionsEnum.MOTORSPORTS)
                , Add.article(listArticles.get(0).getName()).withProductQuantity(listArticles.get(0).getQuantity())
                , Click.on(DetailsArticlePage.GO_TO_CART)
                , RememberThat.theValueOf("subtotal").isAnsweredBy(TextOf.target(ShoppingCartPage.SUBTOTAL_PRICE)));
       
    }

    @Then("she should see total price of the 5 articles on the shopping cart")
    public void sheShouldSeeTotalPriceOfTheArticlesOnTheShoppingCart() {
        theActorInTheSpotlight().should(seeThat(SubTotal.ofShopping(Prices.ofArticles()),
                equalTo(priceToInteger(theActorInTheSpotlight().recall("subtotal")))));
        theActorInTheSpotlight().attemptsTo(Save.priceLinioShopping());
    }

    @When("she search products from Fashion section")
    public void sheSearchProductsFromFashionSection() {
        theActorInTheSpotlight().attemptsTo(OpenCategories.onCategory(CategoriesEnum.FASHION));
       
    }

    @When("she search by following propertie")
    public void sheSearchByFollowingProperties(List<Map<String, String>> properties) {
        theActorInTheSpotlight().attemptsTo(Filters.byBrand(properties.get(0).get("brand"))
                                ,Filters.byColor(properties.get(0).get("color"))
                                ,Filters.byPriceFrom(properties.get(0).get("priceRangeFrom"))
                                        .to(properties.get(0).get("priceRangeTo"))
                                ,Filters.byShipment(properties.get(0).get("shipment")));

    }

    @When("she searches (.*) brand")
    public void sheSearchesAdidasBrand(String brand) {
        theActorInTheSpotlight().attemptsTo(Filters.byBrand(brand));
       
    }

    @When("she searches by (.*) color")
    public void sheSearchesByWhiteColor(String color) {
        theActorInTheSpotlight().attemptsTo(Filters.byColor(color));
       
    }

    @When("she reduces price range from (.*) to (.*)")
    public void sheReducesPriceRangeFromTo(String minPrice, String maxPrice) {
        theActorInTheSpotlight().attemptsTo(Filters
                                            .byPriceFrom(minPrice)
                                            .to(maxPrice));
       
    }

    @When("she chooses the shipment as (.*)")
    public void sheChoosesTheShipmentAsNacional(String shipment) {
       theActorInTheSpotlight().attemptsTo(Filters.byShipment(shipment));
       
    }

    @When("she sorts for lower price")
    public void sheSortsForLowerPrice() {
        theActorInTheSpotlight().attemptsTo(Filters.sortBy(LOWER_PRICE));
    }

    @When("Tina adds to shopping cart the first product found")
    public void tinaAddsToShoppingCartTheFirstProductOfTheSearching() {
        theActorInTheSpotlight().attemptsTo(ScrollBy.aBit()
                            ,Click.on(InitPage.CATALOG_ROW_PRODUCT.of(FIRST))
                            ,AddToCart.quantity(FIRST)
                            ,Click.on(DetailsArticlePage.GO_TO_CART));
       
    }

    @Then("she should see the product to shopping cart")
    public void sheShouldSeeTheProductToShoppingCart() {
        theActorInTheSpotlight().should(seeThat(ListOfProducts.inShoppingCart(), Matchers.hasSize(1)));
    }

    @Given("Tina add several products to shopping cart")
    public void tinaAddSeveralProductsToShoppingCart(List<Article> listArticles) {
        theActorInTheSpotlight().attemptsTo(Adds.articles(listArticles).fromCategory(CONSOLES_AND_VIDEO_GAMES)
                ,GoTo.shoppingCart());
        
       
    }

    @Given("she decides remove all products of the shopping cart")
    public void sheDecidesRemoveAllProductsOfTheShoppingCart() {
        theActorInTheSpotlight().attemptsTo(Clean.allShoppingCart());
       
    }

    @Then("she should not see any products in to list")
    public void sheShouldNotSeeAnyProductsInToList() {
        theActorInTheSpotlight().should(seeThat(TheTarget.textOf(ShoppingCartPage.EMPTY_CART_SHOPPING_MESSAGE),
                Matchers.equalToIgnoringCase("NO TIENES PRODUCTOS EN TU CARRITO")));
       
    }

    @After()
    public void tearDown() {
        OnStage.drawTheCurtain();
    }



    }
