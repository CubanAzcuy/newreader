//
//  TopicView.h
//  NewsReader
//
//  Created by Jonathan Robins on 1/8/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ArticleScrollerCollectionView.h"

@interface TopicView : UIView

@property (strong, nonatomic) IBOutlet UIImageView *backgroundImage;
@property (strong, nonatomic) IBOutlet ArticleScrollerCollectionView *articleCollectionView;

@end
