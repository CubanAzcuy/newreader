//
//  NewsCategoryPageContentViewController.m
//  NewsReader
//
//  Created by Jonathan Robins on 1/7/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import "NewsCategoryPageContentViewController.h"

@interface NewsCategoryPageContentViewController ()
@end

@implementation NewsCategoryPageContentViewController

@synthesize articleTitleLabel;
@synthesize pageIndex, txtTitle;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.newsCategoryLabel.text = self.txtTitle;
    self.backgroundImage.image = [UIImage imageNamed:self.image];

    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
