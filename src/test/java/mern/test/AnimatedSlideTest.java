package mern.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import mern.base.BaseTest;
import mern.pageComponents.homePage;

public class AnimatedSlideTest extends BaseTest {

	@Test
	public void testAutoScrollSlides() throws InterruptedException {
		homePage home = new homePage(getDriver());
		home.goTo("http://localhost:3000/");
		String firstItem = home.activeSlideItem();
		Thread.sleep(3500);
		String nextItem = home.activeSlideItem();
		Assert.assertNotEquals(firstItem, nextItem, "Carousel did not scroll automatically");
	}

	@Test
	public void testSlideNavigation() throws InterruptedException {
		homePage home = new homePage(getDriver());
		home.goTo("http://localhost:3000/");
		// forward Navigation
		String firstItem = home.activeSlideItem();
		home.goToNextSlide();
		Thread.sleep(1000);
		String nextItem = home.activeSlideItem();
		Assert.assertNotEquals(firstItem, nextItem, "Next carousel item is not displayed ");

		// Backward Navigation
		String Item1 = home.activeSlideItem();
		home.goToPrevSlide();
		Thread.sleep(1000);
		String item2 = home.activeSlideItem();
		Assert.assertNotEquals(Item1, item2, "prev carousel item is not displayed ");
	}

}
