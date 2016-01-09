//
//  RootViewController.m
//  PageViewDemo
//
//  Created by abc on 18/02/15.
//  Copyright (c) 2015 com.TheAppGuruz. All rights reserved.
//

#import "RootViewController.h"
#import "CollectionViewArticleCell.h"
#import "TopicView.h"

@interface RootViewController ()

@property (nonatomic,assign) NSUInteger topicIndex;
@property (nonatomic,assign) NSUInteger previousTopicInteger;
@property (nonatomic,assign) NSUInteger scrollViewWidth;
@property (strong, nonatomic) IBOutlet UIScrollView *scrollView;
@property (nonatomic,assign) CGFloat screenWidth;
@end

@implementation RootViewController

@synthesize newsCategoryTitles,newsCategoryImages, articleTitles;

- (void)viewDidLoad
{
    [super viewDidLoad];

    UIBarButtonItem *menuButton = [[UIBarButtonItem alloc]
                                   initWithTitle:@"Menu"
                                   style:UIBarButtonItemStylePlain
                                   target:self
                                   action:nil];
    self.navigationItem.leftBarButtonItem = menuButton;
    
    //fake data
    newsCategoryTitles = @[@"Sports",@"Crime",@"Technology", @"Politics"];
    newsCategoryImages =@[@"1.png",@"2.png",@"3.png", @"4.png"];
    articleTitles = @[@"Steph Curry scores 200 points in one game!", @"Midtown crime at an all-time high!", @"Apple releases the iPhone8c, now with real gold!", @"Trump has change of heart about Muslims after eating falafel!"];
    
    [self.navigationItem setTitle:self.newsCategoryTitles[0]];
    
    //screen width
    CGRect screenRect = [[UIScreen mainScreen] bounds];
    self.screenWidth = screenRect.size.width;
    
    //scrollview
    self.scrollView.delegate = self;
    self.scrollView.pagingEnabled = YES;
    [self.scrollView setContentSize:CGSizeMake(self.screenWidth*self.newsCategoryTitles.count, self.scrollView.frame.size.height)];
    
    //adding news categories to scrollview
    for (int i = 0; i < newsCategoryTitles.count; i++){
        TopicView *contentView = [[[NSBundle mainBundle] loadNibNamed:@"TopicView" owner:self options:nil] objectAtIndex:0];
        contentView.frame = CGRectMake(self.screenWidth * i, 0, self.screenWidth, self.scrollView.frame.size.height);
        contentView.backgroundImage.image = [UIImage imageNamed:self.newsCategoryImages[i]];
        contentView.articleCollectionView.delegate = self;
        contentView.articleCollectionView.dataSource = self;
        contentView.tag = i;
        [self.view bringSubviewToFront:contentView.articleCollectionView];
        [self.scrollView addSubview:contentView];
    }
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
}

#pragma mark - ScrollView Methods
-(void)scrollViewDidEndDecelerating:(UIScrollView *)scrollView {
    CGFloat offset = scrollView.contentOffset.x;
    int index = offset/self.screenWidth;
    [self.navigationItem setTitle:self.newsCategoryTitles[index]];
    for (TopicView *view in [self.scrollView subviews]){
        if(view.tag == index && view.tag != 0){
            self.topicIndex = index;
            [view.articleCollectionView reloadData];
        }
    }
}

#pragma mark - CollectionView Methods
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

    articleCell.articleTitle.text = self.articleTitles[self.topicIndex];
    
    return articleCell;
}

#pragma mark - Other Methods
/*- (NSUInteger) setCurrentIndex:(NSUInteger)index{
 NSUInteger number = 0;
 
 return number;
 }*/

@end
