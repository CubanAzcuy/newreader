//
//  TopicViewController.m
//  NewsReader
//
//  Created by Robert Gross on 1/9/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import "TopicViewController.h"
#import "Topic.h"

@interface TopicViewController ()
@property (strong, nonatomic) IBOutlet UICollectionView *collectionView;
@property (strong, nonatomic) IBOutlet UILabel *titleLabel;

@property NSArray *articleTitles;
@end

@implementation TopicViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.articleTitles = @[@"Steph Curry scores 200 points in one game!", @"Midtown crime at an all-time high!", @"Apple releases the iPhone8c, now with real gold!", @"Trump has change of heart about Muslims after eating falafel!"];
    self.collectionView.delegate = self;
    self.collectionView.dataSource = self;
    self.collectionView.backgroundColor = [UIColor blueColor];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
}

#pragma mark - CollectionView Methods
- (NSInteger)collectionView:(UICollectionView *)view numberOfItemsInSection:(NSInteger)section {

    return 1;
}

- (NSInteger)numberOfSectionsInCollectionView: (UICollectionView *)collectionView {
    return [self.articleTitles count];
}

- (UICollectionViewCell *)collectionView:(UICollectionView *)cv cellForItemAtIndexPath:(NSIndexPath *)indexPath {

    UINib *nib = [UINib nibWithNibName:@"CollectionViewArticleCell" bundle: nil];
    [cv registerNib:nib forCellWithReuseIdentifier:@"ArticleCell"];

    CollectionViewArticleCell *articleCell = (CollectionViewArticleCell*)[cv dequeueReusableCellWithReuseIdentifier:@"ArticleCell" forIndexPath:indexPath];

    articleCell.articleTitle.text = self.articleTitles[indexPath.row];

    return articleCell;
}

- (CGSize)collectionView:(UICollectionView *)collectionView
                  layout:(UICollectionViewLayout *)collectionViewLayout
  sizeForItemAtIndexPath:(NSIndexPath *)indexPath
{
    return CGSizeMake(300.f, 300.f);
}


@end
