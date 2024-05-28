//
//  MainContract.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/22/24.
//

import Foundation

protocol MainView{
    func showLife(lifeCount:Int)
    func showInputError(inputText: String)
    func updateCollectionView()
    func showSuccess(opponentNumber: Int, lifeCount:Int)
    func showFail(opponentNumber: Int)
}

protocol MainViewPresenter {
    func game(userNumber : String)
    func resultListInit()
}
