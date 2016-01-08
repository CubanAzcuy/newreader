//
//  RootViewController.m
//  PageViewDemo
//
//  Created by abc on 18/02/15.
//  Copyright (c) 2015 com.TheAppGuruz. All rights reserved.
//

#import "RootViewController.h"

@interface RootViewController ()

@end

@implementation RootViewController

@synthesize PageViewController,newsCategoryTitles,arrPageImages;

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    UIBarButtonItem *menuButton = [[UIBarButtonItem alloc]
                                   initWithTitle:@"Menu"
                                   style:UIBarButtonItemStylePlain
                                   target:self
                                   action:nil];
    self.navigationItem.leftBarButtonItem = menuButton;
    
    newsCategoryTitles = @[@"Sports",@"Crime",@"Technology"];
    arrPageImages =@[@"1.png",@"2.png",@"3.png"];
    
    self.PageViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"PageViewController"];
    self.PageViewController.dataSource = self;
    
    NewsCategoryPageContentViewController *startingViewController = [self viewControllerAtIndex:0];
    NSArray *viewControllers = @[startingViewController];
    [self.PageViewController setViewControllers:viewControllers direction:UIPageViewControllerNavigationDirectionForward animated:NO completion:nil];
    
    self.PageViewController.view.frame = CGRectMake(0, 0, self.view.frame.size.width, self.view.frame.size.height);
    
    [self addChildViewController:PageViewController];
    [self.view addSubview:PageViewController.view];
    [self.PageViewController didMoveToParentViewController:self];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
}

#pragma mark - Page View Datasource Methods
- (UIViewController *)pageViewController:(UIPageViewController *)pageViewController viewControllerBeforeViewController:(UIViewController *)viewController
{
    NSUInteger index = ((NewsCategoryPageContentViewController*) viewController).pageIndex;
    
    if ((index == 0) || (index == NSNotFound))
    {
        return nil;
    }
    
    index--;
    return [self viewControllerAtIndex:index];
}

- (UIViewController *)pageViewController:(UIPageViewController *)pageViewController viewControllerAfterViewController:(UIViewController *)viewController
{
    NSUInteger index = ((NewsCategoryPageContentViewController*) viewController).pageIndex;
    
    if (index == NSNotFound)
    {
        return nil;
    }
    
    index++;
    if (index == [self.newsCategoryTitles count])
    {
        return nil;
    }
    return [self viewControllerAtIndex:index];
}

#pragma mark - Other Methods
- (NewsCategoryPageContentViewController *)viewControllerAtIndex:(NSUInteger)index
{
    if (([self.newsCategoryTitles count] == 0) || (index >= [self.newsCategoryTitles count])) {
        return nil;
    }
    
    NewsCategoryPageContentViewController *pageContentViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"NewsCategoryPageContentViewController"];
    pageContentViewController.txtTitle = self.newsCategoryTitles[index];
    pageContentViewController.image = self.arrPageImages[index];
    pageContentViewController.pageIndex = index;
    return pageContentViewController;
}

#pragma mark - No of Pages Methods
- (NSInteger)presentationCountForPageViewController:(UIPageViewController *)pageViewController
{
    return [self.newsCategoryTitles count];
}

- (NSInteger)presentationIndexForPageViewController:(UIPageViewController *)pageViewController
{
    return 0;
}

- (IBAction)btnStartAgain:(id)sender
{
    NewsCategoryPageContentViewController *startingViewController = [self viewControllerAtIndex:0];
    NSArray *viewControllers = @[startingViewController];
    [self.PageViewController setViewControllers:viewControllers direction:UIPageViewControllerNavigationDirectionReverse animated:NO completion:nil];
}
@end
