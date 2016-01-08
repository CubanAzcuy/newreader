//
//  RootViewController.m
//  PageViewDemo
//
//  Created by abc on 18/02/15.
//  Copyright (c) 2015 com.TheAppGuruz. All rights reserved.
//

#import "RootViewController.h"
#import "CollectionViewArticleCell.h"

@interface RootViewController ()

@property (strong, nonatomic) IBOutlet ArticleScrollerCollectionView *collectionView;
@property (nonatomic,assign) NSUInteger topicInteger;
@property (nonatomic,assign) NSUInteger previousTopicInteger;

@end

@implementation RootViewController

@synthesize PageViewController,newsCategoryTitles,newsCategoryImages, articleTitles;

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    UIBarButtonItem *menuButton = [[UIBarButtonItem alloc]
                                   initWithTitle:@"Menu"
                                   style:UIBarButtonItemStylePlain
                                   target:self
                                   action:nil];
    self.navigationItem.leftBarButtonItem = menuButton;
    
    newsCategoryTitles = @[@"Sports",@"Crime",@"Technology", @"Politics"];
    newsCategoryImages =@[@"1.png",@"2.png",@"3.png", @"4.png"];
    articleTitles = @[@"Steph Curry scores 200 points in one game!", @"Midtown crime at an all-time high!", @"Apple releases the iPhone8c, now with real gold!", @"Trump has change of heart about Muslims after eating falafel!"];
    
    self.PageViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"PageViewController"];
    self.PageViewController.dataSource = self;
    self.PageViewController.delegate = self;
    
    NewsCategoryPageContentViewController *startingViewController = [self viewControllerAtIndex:0];
    NSArray *viewControllers = @[startingViewController];
    [self.PageViewController setViewControllers:viewControllers direction:UIPageViewControllerNavigationDirectionForward animated:NO completion:nil];
    
    self.PageViewController.view.frame = CGRectMake(0, 0, self.view.frame.size.width, self.view.frame.size.height);
    
    [self addChildViewController:PageViewController];
    [self.view addSubview:PageViewController.view];
    [self.PageViewController didMoveToParentViewController:self];
    
    self.collectionView.delegate = self;
    self.collectionView.dataSource = self;
    
    [self.view bringSubviewToFront:self.collectionView];
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
    self.topicInteger = index;
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
    
    self.topicInteger = index;
    NSLog(@"%d", self.topicInteger);
    return [self viewControllerAtIndex:index];
}

- (void)pageViewController:(UIPageViewController *)pageViewController
willTransitionToViewControllers:(NSArray<UIViewController *> *)pendingViewControllers{
    //article collection view refresh logic here
    [self.collectionView setContentOffset:CGPointZero animated:YES];
    [self.collectionView reloadData];
    
    }

#pragma mark - Other Methods
- (NewsCategoryPageContentViewController *)viewControllerAtIndex:(NSUInteger)index
{
    if (([self.newsCategoryTitles count] == 0) || (index >= [self.newsCategoryTitles count])) {
        return nil;
    }
    
    NewsCategoryPageContentViewController *pageContentViewController = [self.storyboard instantiateViewControllerWithIdentifier:@"NewsCategoryPageContentViewController"];
    pageContentViewController.txtTitle = self.newsCategoryTitles[index];
    pageContentViewController.image = self.newsCategoryImages[index];
    pageContentViewController.pageIndex = index;
    //self.navigationItem.title = self.arrPageImages[index];
    return pageContentViewController;
}

/*- (NSUInteger) setCurrentIndex:(NSUInteger)index{
    NSUInteger number = 0;
    
    return number;
}*/

#pragma mark - No of Pages Methods
- (NSInteger)presentationCountForPageViewController:(UIPageViewController *)pageViewController
{
    return [self.newsCategoryTitles count];
}

- (NSInteger)presentationIndexForPageViewController:(UIPageViewController *)pageViewController
{
    return 0;
}

- (NSInteger)collectionView:(UICollectionView *)view numberOfItemsInSection:(NSInteger)section {
    
    return 1;
}

- (NSInteger)numberOfSectionsInCollectionView: (UICollectionView *)collectionView {
    return [self.newsCategoryTitles count];
}

- (UICollectionViewCell *)collectionView:(UICollectionView *)cv cellForItemAtIndexPath:(NSIndexPath *)indexPath {

    UINib *nib = [UINib nibWithNibName:@"CollectionViewArticleCell" bundle: nil];
    [cv registerNib:nib forCellWithReuseIdentifier:@"ArticleCell"];
    
    CollectionViewArticleCell *articleCell = (CollectionViewArticleCell*)[cv dequeueReusableCellWithReuseIdentifier:@"ArticleCell" forIndexPath:indexPath];

    articleCell.articleTitle.text = self.articleTitles[self.topicInteger];
    
    return articleCell;
}

@end
