//
//  CollectionViewArticleCell.h
//  NewsReader
//
//  Created by Jonathan Robins on 1/8/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface CollectionViewArticleCell : UICollectionViewCell

@property (strong, nonatomic) IBOutlet UIImageView *articleImage;
@property (strong, nonatomic) IBOutlet UILabel *articleTitle;

@end
