insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Sunway Putra Hotel Kuala Lumpur', '100, Jalan Putra', 'Medan Tuanku', 'Kuala Lumpur', 50350, 'Sunway Putra Hotel Kuala Lumpur is located directly opposite the World Trade Centre Kuala Lumpur (formerly known as PWTC).',  'sunwayPutra.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Sheraton Hotel', 'Jalan Utara C', 'Petaling Jaya', 'Selangor', 46200, 'Sheraton, the inimitable hotel and residence carrying the vibe of the city’s central. Unique, romantic and generous.', 'sheraton.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Pavillion Hotel', '168, Bukit Bintang St', 'Bukit Bintang', 'Kuala Lumpur', 55100, 'Pavillion Hotel Kuala Lumpur is in the right middle of a buzzing bussiness and entertainment district.', 'pavillion.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Shangri-La Golden Sands', 'Jalan Batu Ferringhi, Kampung Tanjung Huma', 'Batu Ferringhi', ' Pulau Pinang', 11100, 'Shangri-La is the ultimate family-friendly escape where memories are made for guests of all ages.', 'shangri.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Hard Rock Hotel', 'Batu Ferringhi Beach', 'Batu Ferringhi', ' Pulau Pinang', 11100, 'Hard Rock Hotel Penang offers contemporary-style accommodations along Batu Ferringhi Beach.', 'hardrock.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('WEIL Hotel', '292, Jalan Sultan Idris Shah', 'Perak', 'Ipoh', 30000, 'WEIL Hotel Ipoh welcomes guests with an outdoor swimming pool, a buffet restaurant and free WiFi access.', 'weil.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Double Tree Hilton', 'The Intermark, 348, Jln Tun Razak', 'Kampung Datuk Keramat', 'Kuala Lumpur', 50400, 'Doubletree by Hilton Kuala Lumpur offers accommodations just 5 minutes walk from Ampang Park LRT Station.', 'hilton.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Swiss-Garden Hotel', '117, Jalan Pudu', 'Bukit Bintang', 'Kuala Lumpur', 55100, 'Ideally located in prime destinations in Malaysia,Swiss-Garden exudes the warm hospitality that makes us truly exceptional.', 'swiss.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Promenade Hotel', '1, Jalan Dutamas 1', 'Solaris Dutamas', 'Kota Kinabalu', 50480, 'Located a 5-minute walk to Oceanus Waterfront Mall, Promenade Hotel Kota Kinabalu offers accommodation overlooking the South China Sea.', 'promenade.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('The Everly Putrajaya', '1, Jalan Alamanda 2', 'Presint 1', 'Putrajaya', 62000, 'The Everly Putrajaya has the widest and one of the most advanced array of meeting rooms in Putrajaya.', 'putrajaya.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Bayview Beach Resort', 'Batu Ferringhi Beach', 'Batu Ferringhi', 'Pulau Pinang', 11100, 'Bayview Hotel Georgetown Penang combines contemporary style with an enviable central setting.', 'bayview.');
insert into hotel (hotel_name, street, city, state, zip_code, hotel_des, hotel_image_name) values ('Novetel', 'No 1, Jalan Tupai', 'Taiping', 'Perak', 34000, 'Novotel stands in the Golden Triangle of Kuala Lumpur between Petronas Twin Towers and Bukit Bintang shopping district.', 'novetel.');

insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Single Room', 85, '1 Single Bed', 1, 1, 'sunwayPutra.1', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Double Room', 93, '1 Twin Bed', 1, 1, 'sunwayPutra.2', 5,'Lounge Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Exclusive Room', 98, '1 King Bed & 1 Twin Bed', 1, 1, 'sunwayPutra.3', 5,'Spa Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Superior Room', 199, '1 King Bed', 2, 1, 'sheraton.1', 5,'Guided Tours','Laundry Service');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Double Room', 225, '1 Twin Bed', 2, 1, 'sheraton.2', 5,'Lounge Service','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Quad Room', 280, '1 King Bed & 2 Twin Bed', 2, 1, 'sheraton.3', 5,'Spa Service','Lounge Service');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Mini Suite', 158, '1 Single Bed', 3, 1, 'pavillion.1', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Junior Suite', 188, '1 Twin Bed', 3, 1, 'pavillion.2', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Presidential Suite', 228, '1 King Bed & 1 Twin Bed', 3, 1, 'pavillion.3', 5,'Spa Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Single Room', 99, '1 Single Bed', 4, 1, 'shangri.1', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Double Room', 109, '1 Twin Bed', 4, 1, 'shangri.2', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('VIP Room', 120, '1 King Bed & 1 Twin Bed', 4, 1, 'shangri.3', 5,'Spa Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Single Room', 180, '1 Single Bed', 5, 1, 'hardrock.1', 5,'Guided Tours','Laundry Service');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Twin Room', 215, '1 Twin Bed', 5, 1, 'hardrock.2', 5,'Guided Tours','Laundry Service');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Presidential Suite', 256, '1 King Bed & 1 Twin Bed', 5, 1, 'hardrock.3', 5,'Spa Service','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Single Room', 125, '1 Single Bed', 6, 1, 'weil.1', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Double Room', 140, '1 Twin Bed', 6, 1, 'weil.2', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Exclusive Room', 169, '1 King Bed & 1 Twin Bed', 6, 1, 'weil.3', 5,'Spa Service','Lounge Service');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Single Room', 163, '1 Single Bed', 7, 1, 'hilton.1', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Double Room', 173, '1 Twin Bed', 7, 1, 'hilton.2', 5,'Lounge Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Privilleged Room', 188, '1 King Bed & 1 Twin Bed', 7, 1, 'hilton.3', 5,'Spa Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Mini Room', 121, '1 Single Bed', 8, 1, 'swiss.1', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Standard Room', 140, '1 Twin Bed', 8, 1, 'swiss.2', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Exclusive Room', 169, '1 King Bed & 1 Twin Bed', 8, 1, 'swiss.3', 5,'Spa Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Single Room', 139, '1 Single Bed', 9, 1, 'promenade.1', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Double Room', 155, '1 Twin Bed', 9, 1, 'promenade.2', 5,'Lounge Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('VIP Room', 179, '1 King Bed & 1 Twin Bed', 9, 1, 'promenade.3', 5,'Spa Service','Lounge Service');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Mini Suite', 200, '1 Single Bed', 10, 1, 'putrajaya.1', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Junior Suite', 250, '1 Twin Bed', 10, 1, 'putrajaya.2', 5,'Lounge Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Presidential Suite', 400, '1 King Bed & 1 Twin Bed', 10, 1, 'putrajaya.3', 5,'Spa Service','Lounge Service');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Single Room', 55, '1 Single Bed', 11, 1, 'bayview.1', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Extemded Room', 75, '1 Twin Bed', 11, 1, 'bayview.2', 5,'Buffet Voucher','Guided Tours');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Jumbo Room', 95, '1 King Bed & 1 Twin Bed', 11, 1, 'bayview.3', 5,'Spa Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Standard Room', 101, '1 Single Bed', 12, 1, 'novetel.1', 5,'Lounge Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Enlarged Room', 121, '1 Twin Bed', 12, 1, 'novetel.2', 5,'Lounge Service','Buffet Voucher');
insert into room_type (room_type, room_price, room_bed, hotel_id, is_available, room_image_name, no_of_room, room_service1, room_service2) values ('Exclusive Room', 139, '1 King Bed & 1 Twin Bed', 12, 1, 'novetel.3', 5,'Spa Service','Lounge Service');
insert into room (room_id) values (1001);
insert into room (room_id) values (1002);
insert into room (room_id) values (1003);
insert into room (room_id) values (1004);
insert into room (room_id) values (1005);

insert into room (room_id) values (1031);
insert into room (room_id) values (1032);
insert into room (room_id) values (1033);
insert into room (room_id) values (1034);
insert into room (room_id) values (1035);

insert into room (room_id) values (1081);
insert into room (room_id) values (1082);
insert into room (room_id) values (1083);
insert into room (room_id) values (1084);
insert into room (room_id) values (1085);

insert into room (room_id) values (2001);
insert into room (room_id) values (2002);
insert into room (room_id) values (2003);
insert into room (room_id) values (2004);
insert into room (room_id) values (2005);

insert into room (room_id) values (2041);
insert into room (room_id) values (2042);
insert into room (room_id) values (2043);
insert into room (room_id) values (2044);
insert into room (room_id) values (2045);

insert into room (room_id) values (2081);
insert into room (room_id) values (2082);
insert into room (room_id) values (2083);
insert into room (room_id) values (2084);
insert into room (room_id) values (2085);

insert into room (room_id) values (3001); 
insert into room (room_id) values (3002); 
insert into room (room_id) values (3003); 
insert into room (room_id) values (3004); 
insert into room (room_id) values (3005); 

insert into room (room_id) values (3041);
insert into room (room_id) values (3042);
insert into room (room_id) values (3043);
insert into room (room_id) values (3044);
insert into room (room_id) values (3045);

insert into room (room_id) values (3081);
insert into room (room_id) values (3082);
insert into room (room_id) values (3083);
insert into room (room_id) values (3084);
insert into room (room_id) values (3085);

insert into room (room_id) values (4001);
insert into room (room_id) values (4002);
insert into room (room_id) values (4003);
insert into room (room_id) values (4004);
insert into room (room_id) values (4005);

insert into room (room_id) values (4041);
insert into room (room_id) values (4042);
insert into room (room_id) values (4043);
insert into room (room_id) values (4044);
insert into room (room_id) values (4045);

insert into room (room_id) values (4081);
insert into room (room_id) values (4082);
insert into room (room_id) values (4083);
insert into room (room_id) values (4084);
insert into room (room_id) values (4085);

insert into room (room_id) values (5001);
insert into room (room_id) values (5002);
insert into room (room_id) values (5003);
insert into room (room_id) values (5004);
insert into room (room_id) values (5005);

insert into room (room_id) values (5041);
insert into room (room_id) values (5042);
insert into room (room_id) values (5043);
insert into room (room_id) values (5044);
insert into room (room_id) values (5045);

insert into room (room_id) values (5081);
insert into room (room_id) values (5082);
insert into room (room_id) values (5083);
insert into room (room_id) values (5084);
insert into room (room_id) values (5085);

insert into room (room_id) values (6001);
insert into room (room_id) values (6002);
insert into room (room_id) values (6003);
insert into room (room_id) values (6004);
insert into room (room_id) values (6005);

insert into room (room_id) values (6041);
insert into room (room_id) values (6042);
insert into room (room_id) values (6043);
insert into room (room_id) values (6044);
insert into room (room_id) values (6045);

insert into room (room_id) values (6081);
insert into room (room_id) values (6082);
insert into room (room_id) values (6083);
insert into room (room_id) values (6084);
insert into room (room_id) values (6085);

insert into room (room_id) values (7001);
insert into room (room_id) values (7002);
insert into room (room_id) values (7003);
insert into room (room_id) values (7004);
insert into room (room_id) values (7005);

insert into room (room_id) values (7041);
insert into room (room_id) values (7042);
insert into room (room_id) values (7043);
insert into room (room_id) values (7044);
insert into room (room_id) values (7045);

insert into room (room_id) values (7081);
insert into room (room_id) values (7082);
insert into room (room_id) values (7083);
insert into room (room_id) values (7084);
insert into room (room_id) values (7085);

insert into room (room_id) values (8001);
insert into room (room_id) values (8002);
insert into room (room_id) values (8003);
insert into room (room_id) values (8004);
insert into room (room_id) values (8005);

insert into room (room_id) values (8041);
insert into room (room_id) values (8042);
insert into room (room_id) values (8043);
insert into room (room_id) values (8044);
insert into room (room_id) values (8045);

insert into room (room_id) values (8081);
insert into room (room_id) values (8082);
insert into room (room_id) values (8083);
insert into room (room_id) values (8084);
insert into room (room_id) values (8085);

insert into room (room_id) values (9001);
insert into room (room_id) values (9002);
insert into room (room_id) values (9003);
insert into room (room_id) values (9004);
insert into room (room_id) values (9005);

insert into room (room_id) values (9041);
insert into room (room_id) values (9042);
insert into room (room_id) values (9043);
insert into room (room_id) values (9044);
insert into room (room_id) values (9045);

insert into room (room_id) values (9081);
insert into room (room_id) values (9082);
insert into room (room_id) values (9083);
insert into room (room_id) values (9084);
insert into room (room_id) values (9085);

insert into room (room_id) values (10001);
insert into room (room_id) values (10002);
insert into room (room_id) values (10003);
insert into room (room_id) values (10004);
insert into room (room_id) values (10005);

insert into room (room_id) values (10041);
insert into room (room_id) values (10042);
insert into room (room_id) values (10043);
insert into room (room_id) values (10044);
insert into room (room_id) values (10045);

insert into room (room_id) values (10081);
insert into room (room_id) values (10082);
insert into room (room_id) values (10083);
insert into room (room_id) values (10084);
insert into room (room_id) values (10085);

insert into room (room_id) values (11001);
insert into room (room_id) values (11002);
insert into room (room_id) values (11003);
insert into room (room_id) values (11004);
insert into room (room_id) values (11005);

insert into room (room_id) values (11041);
insert into room (room_id) values (11042);
insert into room (room_id) values (11043);
insert into room (room_id) values (11044);
insert into room (room_id) values (11045);

insert into room (room_id) values (11081);
insert into room (room_id) values (11082);
insert into room (room_id) values (11083);
insert into room (room_id) values (11084);
insert into room (room_id) values (11085);

insert into room (room_id) values (12001);
insert into room (room_id) values (12002);
insert into room (room_id) values (12003);
insert into room (room_id) values (12004);
insert into room (room_id) values (12005);

insert into room (room_id) values (12041);
insert into room (room_id) values (12042);
insert into room (room_id) values (12043);
insert into room (room_id) values (12044);
insert into room (room_id) values (12045);

insert into room (room_id) values (12081);
insert into room (room_id) values (12082);
insert into room (room_id) values (12083);
insert into room (room_id) values (12084);
insert into room (room_id) values (12085);

update room
set hotel_id = 1
where room_id like '1%';
update room
set hotel_id = 2
where room_id like '2%';
update room
set hotel_id = 3
where room_id like '3%';
update room
set hotel_id = 4
where room_id like '4%';
update room
set hotel_id = 5
where room_id like '5%';
update room
set hotel_id = 6
where room_id like '6%';
update room
set hotel_id = 7
where room_id like '7%';
update room
set hotel_id = 8
where room_id like '8%';
update room
set hotel_id = 9
where room_id like '9%';
update room
set hotel_id = 10
where room_id between 10000 and 10999;
update room
set hotel_id = 11
where room_id between 11000 and 11999;
update room
set hotel_id = 12
where room_id between 12000 and 12999;

update room
set room_no = room_id - (hotel_id * 1000);
update room
set room_type_id = 1
where room_no > 0 and hotel_id = 1;
update room
set room_type_id = 2
where room_no > 30 and hotel_id = 1;
update room
set room_type_id = 3
where room_no > 80 and hotel_id = 1;
update room
set room_type_id = 4
where room_no > 0 and hotel_id = 2;
update room
set room_type_id = 5
where room_no > 40 and hotel_id = 2;
update room
set room_type_id = 6
where room_no > 80 and hotel_id = 2;
update room
set room_type_id = 7
where room_no > 0 and hotel_id = 3;
update room
set room_type_id = 8
where room_no > 30 and hotel_id = 3;
update room
set room_type_id = 9
where room_no > 80 and hotel_id = 3;
update room
set room_type_id = 10
where room_no > 0 and hotel_id = 4;
update room
set room_type_id = 11
where room_no > 30 and hotel_id = 4;
update room
set room_type_id = 12
where room_no > 80 and hotel_id = 4;
update room
set room_type_id = 13
where room_no > 0 and hotel_id = 5;
update room
set room_type_id = 14
where room_no > 30 and hotel_id = 5;
update room
set room_type_id = 15
where room_no > 80 and hotel_id = 5;
update room
set room_type_id = 16
where room_no > 0 and hotel_id = 6;
update room
set room_type_id = 17
where room_no > 30 and hotel_id = 6;
update room
set room_type_id = 18
where room_no > 80 and hotel_id = 6;
update room
set room_type_id = 19
where room_no > 0 and hotel_id = 7;
update room
set room_type_id = 20
where room_no > 30 and hotel_id = 7;
update room
set room_type_id = 21
where room_no > 80 and hotel_id = 7;
update room
set room_type_id = 22
where room_no > 0 and hotel_id = 8;
update room
set room_type_id = 23
where room_no > 30 and hotel_id = 8;
update room
set room_type_id = 24
where room_no > 80 and hotel_id = 8;
update room
set room_type_id = 25
where room_no > 0 and hotel_id = 9;
update room
set room_type_id = 26
where room_no > 30 and hotel_id = 9;
update room
set room_type_id = 27
where room_no > 80 and hotel_id = 9;
update room
set room_type_id = 28
where room_no > 0 and hotel_id = 10;
update room
set room_type_id = 29
where room_no > 30 and hotel_id = 10;
update room
set room_type_id = 30
where room_no > 80 and hotel_id = 10;
update room
set room_type_id = 31
where room_no > 0 and hotel_id = 11;
update room
set room_type_id = 32
where room_no > 30 and hotel_id = 11;
update room
set room_type_id = 33
where room_no > 80 and hotel_id = 11;
update room
set room_type_id = 34
where room_no > 0 and hotel_id = 12;
update room
set room_type_id = 35
where room_no > 30 and hotel_id = 12;
update room
set room_type_id = 36
where room_no > 80 and hotel_id = 12;


insert into admin (admin_name, email, password, phone) values ('Lau Pei Tong', 'laupeitong@catravel.com', 'laupeitong', '016-3769280');
insert into admin (admin_name, email, password, phone) values ('Lee Wen Jie', 'leewenjie@catravel.com', 'leewenjie', '016-5567895');
insert into admin (admin_name, email, password, phone) values ('Lau Say Heng', 'lausayheng@catravel.com', 'lausayheng', '016-74589641');


update hotel
set min_price = 85
where hotel_id = 1;
update hotel
set min_price = 199
where hotel_id = 2;
update hotel
set min_price = 158
where hotel_id = 3;
update hotel
set min_price = 99
where hotel_id = 4;
update hotel
set min_price = 180
where hotel_id = 5;
update hotel
set min_price = 125
where hotel_id = 6;
update hotel
set min_price = 163
where hotel_id = 7;
update hotel
set min_price = 121
where hotel_id = 8;
update hotel
set min_price = 139
where hotel_id = 9;
update hotel
set min_price = 200
where hotel_id = 10;
update hotel
set min_price = 55
where hotel_id = 11;
update hotel
set min_price = 101
where hotel_id = 12;