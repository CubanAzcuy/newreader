//
//  RootViewController.h
//  NewsReader
//
//  Created by Jonathan Robins on 1/7/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface RootViewController : UIViewController <UIScrollViewDelegate, UICollectionViewDataSource,UICollectionViewDelegateFlowLayout>

@property (nonatomic,strong) NSArray *newsCategoryTitles;
@property (nonatomic,strong) NSArray *newsCategoryImages;
@property (nonatomic,strong) NSArray *articleTitles;

@end
