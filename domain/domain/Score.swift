//
//  Score.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/21/24.
//

import Foundation

public struct Score : Equatable{
    public let strike : Int
    public let ball : Int
    
    public init(ball: Int, strike: Int) {
        self.strike = strike
        self.ball = ball
    }
}
