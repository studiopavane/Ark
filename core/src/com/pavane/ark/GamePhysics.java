package com.pavane.ark;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.math.*;

class GamePhysics {
	public World _world;
	
	public void create(){
		Vector2 gravity = new Vector2( 0f, 0f );
		boolean sleep = true;
		_world = new World( gravity, sleep );
	}
     
	public void update(){
		_world.step( 1f / 5f, 1, 1 ); 
	}
	
	public void addBody( int initx, int inity, BodyType type,
			 float hx, float hy, Vector2 center, float angle ){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = type;
		bodyDef.position.x = initx;
		bodyDef.position.y = inity;
		
		Body body = _world.createBody( bodyDef );
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox( hx,  hy, center, angle );
		
		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 1000f;
		fd.restitution = 1f;
		body.createFixture( fd );
	}

 }