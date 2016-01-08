//
//  RootViewController.h
//  NewsReader
//
//  Created by Jonathan Robins on 1/7/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NewsCategoryPageContentViewController.h"

@interface RootViewController : UIViewController <UIPageViewControllerDataSource, UICollectionViewDataSource,UICollectionViewDelegateFlowLayout>

@property (nonatomic,strong) UIPageViewController *PageViewController;
@property (nonatomic,strong) NSArray *newsCategoryTitles;
@property (nonatomic,strong) NSArray *arrPageImages;

- (NewsCategoryPageContentViewController *)viewControllerAtIndex:(NSUInteger)index;

@end
