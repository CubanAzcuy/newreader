//
//  RootViewController.h
//  NewsReader
//
//  Created by Jonathan Robins on 1/7/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NewsCategoryPageContentViewController.h"

@interface RootViewController : UIViewController <UIPageViewControllerDataSource, UIPageViewControllerDelegate, UICollectionViewDataSource,UICollectionViewDelegateFlowLayout>

@property (nonatomic,strong) UIPageViewController *PageViewController;
@property (nonatomic,strong) NSArray *newsCategoryTitles;
@property (nonatomic,strong) NSArray *newsCategoryImages;
@property (nonatomic,strong) NSArray *articleTitles;

- (NewsCategoryPageContentViewController *)viewControllerAtIndex:(NSUInteger)index;

@end
