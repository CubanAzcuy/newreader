//
//  TopicPageViewController.m
//  NewsReader
//
//  Created by Robert Gross on 1/9/16.
//  Copyright © 2016 robins. All rights reserved.
//

#import "TopicPageViewController.h"
#import "Topic.h"
#import "TopicViewController.h"

@interface TopicPageViewController ()
@property NSArray *topics;
@property NSArray *articles;
@property NSMutableArray *topicViewControllers;
@end

@implementation TopicPageViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    [self loadData];
}

- (void)loadData {
    self.topics = @[[[Topic alloc] init: @"Sports"] ,[[Topic alloc] init: @"Crime"],[[Topic alloc] init: @"Tech"]];
    self.topicViewControllers = [@[] mutableCopy];
    
    NSUInteger index = 0;
    for (Topic *topic in self.topics) {
        [self.topicViewControllers addObject:[self createTopicViewController:topic atIndex:index]];
        index++;
    }
    
    NSArray *viewControllers = @[self.topicViewControllers[0]];
    
    [self setViewControllers:viewControllers direction:UIPageViewControllerNavigationDirectionForward animated:NO completion:nil];
    
    
    self.dataSource = self;
    self.delegate = self;
}

- (TopicViewController *)createTopicViewController:(Topic *)topic atIndex:(NSUInteger)index {
    TopicViewController *viewController = [[TopicViewController alloc] initWithNibName:@"TopicViewController" bundle:nil];
    viewController.topic = topic;
    viewController.index = index;
    return viewController;
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (UIViewController *)pageViewController:(UIPageViewController *)pageViewController viewControllerBeforeViewController:(UIViewController *)viewController {

    TopicViewController *topicViewController = (TopicViewController *)viewController;
    NSUInteger index = topicViewController.index;
    index--;
    
    if(-1 == index)
        return nil;
    
    return self.topicViewControllers[index];
}

- (UIViewController *)pageViewController:(UIPageViewController *)pageViewController viewControllerAfterViewController:(UIViewController *)viewController {
    TopicViewController *topicViewController = (TopicViewController *)viewController;
    NSUInteger index = topicViewController.index;
    index++;
    
    if([self.topics count] == index)
        return nil;
    
    return self.topicViewControllers[index];
}


- (NSInteger)presentationCountForPageViewController:(UIPageViewController *)pageViewController
{
    return [self.topics count];
}

- (NSInteger)presentationIndexForPageViewController:(UIPageViewController *)pageViewController {
    return 0;
}


@end
