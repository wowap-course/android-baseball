//
//  ViewController.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/18/24.
//

import UIKit

class StartViewController: UIViewController, StartView {
    
    @IBOutlet weak var lifeLabel: UILabel!
    
    var presenter : StartPresenter!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        do {
            self.presenter = try StartPresenter(view: self)
        } catch {
            print("에러 발생: \(error)")
        }
    }
    
    func showLife(lifeCount:Int) {
        lifeLabel.text = String(lifeCount)
    }
    
    func startGame(lifeCount:Int) {
        let storyboard = UIStoryboard(name: "MainView", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "MainViewController") as! MainViewController
        
        vc.lifeCount = lifeCount
        
        let navController = UINavigationController(rootViewController: vc)
        
        navController.modalPresentationStyle = .fullScreen
        present(navController, animated: true)
    }
    
    @IBAction func btnMinus(_ sender: Any) {
        presenter.decreaseLifeCount()
    }
    
    @IBAction func btnPlus(_ sender: Any) {
        presenter.increaseLifeCount()
    }
    
    @IBAction func btnStart(_ sender: Any) {
        presenter.startGame()
    }
    
}

