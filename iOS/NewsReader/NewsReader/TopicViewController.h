//
//  TopicViewController.h
//  NewsReader
//
//  Created by Robert Gross on 1/9/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Topic.h"
#import "CollectionViewArticleCell.h"

@interface TopicViewController : UIViewController <UICollectionViewDataSource, UICollectionViewDelegate>
@property Topic *topic;
@property NSUInteger index;
@end
