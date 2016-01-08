//
//  NewsCategoryPageContentViewController.h
//  NewsReader
//
//  Created by Jonathan Robins on 1/7/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ArticleScrollerCollectionView.h"

@interface NewsCategoryPageContentViewController : UIViewController

@property NSUInteger pageIndex;
@property (strong, nonatomic) IBOutlet UILabel *articleTitleLabel;
@property (strong, nonatomic) IBOutlet UILabel *newsCategoryLabel;
@property (strong, nonatomic) IBOutlet UIImageView *backgroundImage;
@property NSString *txtTitle;
@property NSString *image;

@end
