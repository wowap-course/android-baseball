//
//  OpponentBall.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/21/24.
//

import Foundation

public class OpponentBall : Ball{
    
    public private(set) var numbers : [Int]
    
    public init(numberGenerator : NumberGenerator){
        self.numbers = numberGenerator.getNumbers()
    }
    
}
