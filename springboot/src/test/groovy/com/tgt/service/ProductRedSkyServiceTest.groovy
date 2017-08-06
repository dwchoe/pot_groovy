package com.tgt.service

import com.tgt.model.ProductRedSky
import org.junit.Assert

import static org.mockito.Mockito.*;

import org.junit.Before
import org.junit.Test
import org.springframework.web.client.RestTemplate

/**
 * Created by z0019mz on 7/31/17.
 */
class ProductRedSkyServiceTest {
    ProductRedSkyService productRedSkyService;

    RestTemplate redSkyServiceMock;

    @Before
    public void setup() {
        productRedSkyService = new ProductRedSkyService()

        redSkyServiceMock = mock(RestTemplate.class)

        productRedSkyService.redSkyService = redSkyServiceMock
    }

    @Test
    public void shoudReturnProductSuccessfully() {
        String url = "http://redsky.target.com/v2/pdp/tcin/50570764?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics"
        String product = "{\"product\":{\"available_to_promise_network\":{\"product_id\":\"50570764\",\"id_type\":\"TCIN\",\"available_to_promise_quantity\":218.0,\"street_date\":\"2016-09-30T05:00:00.000Z\",\"availability\":\"AVAILABLE\",\"online_available_to_promise_quantity\":218.0,\"stores_available_to_promise_quantity\":0.0,\"availability_status\":\"IN_STOCK\",\"multichannel_options\":[],\"is_infinite_inventory\":false,\"loyalty_availability_status\":\"IN_STOCK\",\"loyalty_purchase_start_date_time\":\"1970-01-01T00:00:00.000Z\",\"is_loyalty_purchase_enabled\":false},\"deep_red_labels\":{\"total_count\":0,\"labels\":[]},\"item\":{\"tcin\":\"50570764\",\"bundle_components\":{\"product_relationship_type\":\"DA Compnt\",\"product_relationship_type_code\":\"DCMP\",\"is_kit_master\":false,\"is_standard_item\":false,\"related_master_tcin\":\"50570770\",\"related_master_dpci\":\"087-06-5548\"},\"dpci\":\"087-06-5552\",\"upc\":\"039897017679\",\"product_description\":{\"title\":\"Star Wars Rogue One -  Death Trooper Action Figure 18\",\"downstream_description\":\"Straight out of Star Wars: Rogue One comes the Jakks BIG-FIGS 18â Imperial Death Trooper. The elite soldiers of Imperial Intelligence, Death Troopers are encased in specialized stormtrooper armor with a dark, ominous gleam. This incredible 20-inch-scale BIG-FIGS Death Trooper features 7 points of articulation for fully poseable action and includes 2 blaster accessories to eliminate those who stand in the way of the Empire. Celebrate the excitement and action of Rogue One with Jakksâ BIG-FIGS 18â Imperial Death Trooper!\",\"bullet_description\":[\"<B>Includes:</B> figure\",\"<B>Material:</B> metal, plastic\",\"<B>Dimensions:</B> 20 inches H x 8 inches W\",\"<B>Weight:</B> 1.42 pounds\",\"<B>Suggested Age:</B> 3 Years and Up\",\"<B>Battery:</B> no battery used\",\"<B>Care and Cleaning:</B> Wipe Clean with a Damp Cloth\"],\"soft_bullets\":{\"title\":\"highlights\",\"bullets\":[\"Authentic Star Wars Rogue One Action Figure\",\"7 points of articulation\",\"Recommended for Ages: 3+\"]},\"general_description\":\"Star Wars\"},\"buy_url\":\"https://www.target.com/p/star-wars-rogue-one-death-trooper-action-figure-18/-/A-50570764\",\"enrichment\":{\"images\":[{\"base_url\":\"https://target.scene7.com/is/image/Target/\",\"primary\":\"50570764\",\"alternate_urls\":[\"50570764_Alt02\",\"50570764_Alt03\",\"50570764_Alt04\",\"50570764_Alt05\",\"50570764_Alt06\"],\"content_labels\":[{\"image_url\":\"50570764\",\"displayed_in_image\":{}},{\"image_url\":\"50570764_Alt02\",\"displayed_in_image\":{}},{\"image_url\":\"50570764_Alt03\",\"displayed_in_image\":{}},{\"image_url\":\"50570764_Alt04\",\"displayed_in_image\":{}},{\"image_url\":\"50570764_Alt05\",\"displayed_in_image\":{}},{\"image_url\":\"50570764_Alt06\",\"displayed_in_image\":{}}]}],\"video_content_list\":[{\"sequence_id\":1,\"entry_id\":\"0_g7pwk5cn\",\"title\":\"Product Detail - Star Wars Rogue One Jyn Erso Action Figure 20\",\"runtime\":0.28}],\"sales_classification_nodes\":[{\"node_id\":\"5q0ga\"},{\"node_id\":\"4rsft\"},{\"node_id\":\"5xt87\"},{\"node_id\":\"5ouvg\"},{\"node_id\":\"5ewio\"},{\"node_id\":\"4ymz4\"},{\"node_id\":\"56gcy\"},{\"node_id\":\"5tg3d\"},{\"node_id\":\"4siwh\"},{\"node_id\":\"5tdvp\"},{\"node_id\":\"4y7ox\"}]},\"return_method\":\"This item can be returned to any Target store or Target.com.\",\"handling\":{\"import_designation_description\":\"Imported\"},\"recall_compliance\":{\"is_product_recalled\":false},\"tax_category\":{\"tax_code_id\":99999,\"tax_code\":\"99999\"},\"display_option\":{\"is_size_chart\":false},\"fulfillment\":{\"is_po_box_prohibited\":true,\"po_box_prohibited_message\":\"We regret that this item cannot be shipped to PO Boxes.\"},\"package_dimensions\":{\"weight\":\"1.15\",\"weight_unit_of_measure\":\"POUND\",\"width\":\"8.0\",\"depth\":\"18.5\",\"height\":\"3.7\",\"dimension_unit_of_measure\":\"INCH\"},\"environmental_segmentation\":{\"is_lead_disclosure\":false},\"manufacturer\":{},\"product_classification\":{\"product_type\":\"544\",\"product_type_name\":\"TOYS\",\"item_type_name\":\"dolls, puppets, and figures\",\"item_type\":{\"category_type\":\"Item Type: Toys\",\"type\":44320436,\"name\":\"action figures\"}},\"product_brand\":{\"brand\":\"Star Wars\",\"manufacturer_brand\":\"Star Wars\"},\"item_state\":\"READY_FOR_LAUNCH\",\"specifications\":[],\"choking_hazard\":[\"WARNING: choking hazard - small parts. Not for children under 3 yrs.\"],\"attributes\":{\"has_prop65\":\"N\",\"is_hazmat\":\"N\",\"manufacturing_brand\":\"Star Wars\",\"max_order_qty\":5,\"merch_class\":\"GAMES/DIECAST/ACTION FIGURES\",\"merch_subclass\":6,\"return_method\":\"This item can be returned to any Target store or Target.com.\"},\"country_of_origin\":\"CN\",\"relationship_type_code\":\"Stand Alone\",\"subscription_eligible\":false,\"ribbons\":[],\"tags\":[],\"estore_item_status_code\":\"A\",\"return_policies\":{\"user\":\"Regular Guest\",\"policyDays\":\"90\",\"guestMessage\":\"This item must be returned within 90 days of the ship date. See return policy for details.\"}"

        when(redSkyServiceMock.getForObject(url,String.class)).thenReturn(product)

        ProductRedSky productRedSky = productRedSkyService.getProductInfo("50570764")

        Assert.assertEquals("50570764", productRedSky.productId)
    }
}
